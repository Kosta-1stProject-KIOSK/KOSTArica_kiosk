package com.kiosk.view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kiosk.admin.model.dao.CouponDAO;
import com.kiosk.admin.model.dao.CouponDAOImpl;
import com.kiosk.admin.model.dto.Coupon;

import com.kiosk.member.model.dao.MemberDAO;
import com.kiosk.member.model.dao.MemberDAOImpl;
import com.kiosk.member.model.dto.Member;
import com.kiosk.member.model.dto.Menu;
import com.kiosk.member.model.dto.MenuOption;

public class MemberCouponViewHB {
	
	public static void handleMemberFlow(Map<Menu, MenuOption> cart) {
        Scanner sc = new Scanner(System.in);

        try {
        System.out.println("\n회원 적립 및 쿠폰 사용을 진행합니다.");

        // 주문 요약 출력
        int totalPrice = 0;
        
        for (Map.Entry<Menu, MenuOption> entry : cart.entrySet()) {
        	
            Menu menu = entry.getKey();
            MenuOption opt = entry.getValue();
            
            int price = (menu.getBasicPrice() + opt.getExtraFee());
            totalPrice += price;

            System.out.println("\n" + menu.getMenuName());
            System.out.println("- " + opt.getTemperature());
            System.out.println("- " + opt.getSize());
            if (opt.getShot() > 0) System.out.println("- +" + opt.getShot() + "샷");
            if (opt.getWhipping() == 1) System.out.println("- 휘핑 추가");
            System.out.println("총 가격: " + price + "원");
        }

        System.out.println("\n전화번호(숫자만)를 입력해주세요.");
        System.out.print("입력: ");
        String phone = sc.nextLine().trim();
        
        if(phone.matches("{10,11}")) {
        	if(phone.length() == 11) {
        		phone = phone.replaceFirst("({3})({4})({4})", "$1-$2-$3");
        	}
        	else {
        		phone = phone.replaceFirst("({3})({3})({4})", "$1-$2-$3");
        	}
        } else {
        	 System.out.println("전화번호는 숫자만 입력해주세요.");
        	 return;
        }
        
        
        //보유 쿠폰 조회 및 출력
        MemberDAO memberDao = new MemberDAOImpl();
        Member member = memberDao.searchById(phone);  // 전화번호 = memberId

        if (member == null) {
            System.out.println("신규 회원입니다. 이름과 생년월일을 입력해주세요.");
            System.out.print("이름: ");
            String name = sc.nextLine();

            System.out.print("생년월일(YYYYMMDD): ");
            String birth = sc.nextLine();

            String joinDate = java.time.LocalDate.now().toString();  // 현재 날짜
            member = new Member(phone, name, birth, joinDate, 0);     // 스탬프 0개로 시작

            memberDao.insert(member);
            System.out.println(name + " 님, 회원가입이 완료되었습니다.");
        } else {
            System.out.println(member.getMemberName() + " 님, 환영합니다!");
        }
        
        
        
        //쿠폰 자동 발급 및 스탬프 적립  
        CouponDAO couponDao = new CouponDAOImpl();
        List<Coupon> coupons = couponDao.searchByMember(member.getMemberID());

        int selectedDiscount = 0;

        if (coupons == null || coupons.isEmpty()) {
            System.out.println("보유 중인 쿠폰이 없습니다.");
        } else {
            System.out.println("보유 중인 쿠폰:");
            for (int i = 0; i < coupons.size(); i++) {
                Coupon c = coupons.get(i);
                System.out.printf("%d. %s (할인: %d원, 사용기한: %s)%s\n",
                    i + 1,
                    c.getCouponName(),
                    c.getDiscount(),
                    c.getValidUntil(),
                    c.getIsUsed() == 1 ? "[사용됨]" : ""
                );
            }

            System.out.println("쿠폰을 사용하시겠습니까? (번호 입력, 사용 안 함은 0)");
            System.out.print("선택: ");
            int couponChoice = Integer.parseInt(sc.nextLine());

            if (couponChoice > 0 && couponChoice <= coupons.size()) {
                Coupon chosen = coupons.get(couponChoice - 1);
                if (chosen.getIsUsed() == 1) {
                    System.out.println("이미 사용된 쿠폰입니다.");
                } else {
                    selectedDiscount = chosen.getDiscount();
                    couponDao.updateUsage(chosen.getCouponNo(), 1);  // 사용 처리
                    System.out.println(" 쿠폰이 적용되었습니다! -" + selectedDiscount + "원");
                }
            } else {
                System.out.println("쿠폰을 사용하지 않았습니다.");
            }
        }
        
        
        
        int currentStamp = member.getStampCount();
        currentStamp += 1;

        if (currentStamp >= 10) {
            System.out.println("축하합니다! 스탬프 10개 적립 완료! 쿠폰이 발급됩니다.");

            String today = LocalDate.now().toString();
            String validUntil = LocalDate.now().plusYears(1).toString();

            Coupon newCoupon = new Coupon(
                0,
                "회원적립쿠폰",
                3000,
                today,
                validUntil,
                0,
                member.getMemberID()
            );

            CouponDAO coupDao = new CouponDAOImpl();
            coupDao.insert(newCoupon);
            System.out.println("'회원적립쿠폰'이 발급되었습니다!");

            currentStamp = 0; // 초기화
        }

        member.setStampCount(currentStamp);
        MemberDAO memDao = new MemberDAOImpl();
        memDao.update(member);  // 스탬프 저장
        System.out.println("현재 스탬프 수: " + currentStamp + "개");
        
        
        
        //쿠폰 선택하여 적용 → 최종 가격 계산
        int originalTotal = 0;
        
        for (Map.Entry<Menu, MenuOption> entry : cart.entrySet()) {
            Menu m = entry.getKey();
            MenuOption o = entry.getValue();
            originalTotal += m.getBasicPrice() + o.getExtraFee();
        }
        
        int finalTotal = originalTotal - selectedDiscount;
        
        if (finalTotal < 0) finalTotal = 0;

        System.out.println("\n결제 금액 요약");
        System.out.println("- 기존 금액: " + originalTotal + "원");
        System.out.println("- 할인 금액: " + selectedDiscount + "원");
        System.out.println("> 최종 결제 금액: " + finalTotal + "원");

        
        // 결제로 이동
        System.out.println("\n결제를 진행합니다...");
        try {
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
        } catch (InterruptedException e) {
            // 무시
        }

        System.out.println("결제가 완료되었습니다. 감사합니다!");
        System.out.println("처음 화면으로 돌아갑니다.\n");
        System.out.println("\n[임시 출력] 회원 기능은 현재 개발 중입니다.");
        System.out.println("전화번호 입력: " + phone);
        System.out.println("주문이 완료된 것으로 가정하고 결제로 이동합니다.");

        // TODO: 아래 로직은 개발 완료 시 PaymentView로 분기
         PaymentViewHB.directPay(cart);
        }catch(SQLException e) {
        	System.out.println("데이터베이스 오류");
        	e.printStackTrace();
        }
    }
}
