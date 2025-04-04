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
import com.kiosk.member.model.dto.Order;
import com.kiosk.member.service.OrderService;

public class MemberCouponViewHB {
	
	public static void handleMemberFlow(Map<Menu, MenuOption> cart) {
        Scanner sc = new Scanner(System.in);
        int couponChoice = 0;
        
        try {
        System.out.println();
        System.out.println("╭╼|═════════════════════════════════════════════|╾╮");	
        System.out.println("    적립 & 쿠폰 ");
        MemberDAO memberDao = new MemberDAOImpl();
        CouponDAO couponDao = new CouponDAOImpl();
        
        // 주문 요약 출력
        int totalPrice = 0;
        
        for (Map.Entry<Menu, MenuOption> entry : cart.entrySet()) {
        	
            Menu menu = entry.getKey();
            MenuOption opt = entry.getValue();
            
            int price = (menu.getBasicPrice() + opt.getExtraFee());
            totalPrice += price;

            System.out.println("╭────────────────────────.★..─╮");
            System.out.println("  " + menu.getMenuName());
            System.out.println(" - " + opt.getTemperature());
            System.out.println(" - " + opt.getSize());
            if (opt.getShot() > 0) System.out.println(" - +" + opt.getShot() + "샷");
            if (opt.getWhipping() == 1) System.out.println(" - 휘핑 추가");
            System.out.println(" 총 가격: " + price + "원");
            System.out.println("╰─..★.────────────────────────╯");
        }
            System.out.println("────────────────────────────────");
            System.out.println("전화번호(숫자만)를 입력해주세요.");
            System.out.println("────────────────────────────────");
        System.out.print("입력: ");
        String phone = sc.nextLine().trim();
        
        if(phone.matches("\\d{10,11}")) {
        	if(phone.length() == 11) {
        		phone = phone.replaceFirst("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
        	}
        	else {
        		phone = phone.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3");
        	}
        } else {
        	 System.out.println("전화번호는 숫자만 입력해주세요.");
        	 return;
        }
        
        
        //보유 쿠폰 조회 및 출력
        memberDao = new MemberDAOImpl();
        Member member = memberDao.searchById(phone);  // 전화번호 = memberId

        if (member == null) {
        	System.out.println();
            System.out.println("반갑습니다.");
            System.out.println("신규 회원 등록을 위해 이름과 생년월일을 입력해주세요.");
            System.out.println("────────────────────────────────");
            System.out.print("이름: ");
            String name = sc.nextLine();

            System.out.print("생년월일(YYYYMMDD): ");
            String birth = sc.nextLine();

            String joinDate = java.time.LocalDate.now().toString();  // 현재 날짜
            member = new Member(phone, name, birth, joinDate, 0);     // 스탬프 0개로 시작

            memberDao.insert(member);
            System.out.println();
            System.out.println("────────────────────────────────");
            System.out.println(name + " 님");
            System.out.println("회원가입이 완료되었습니다.");
            
        } else {
            System.out.println(member.getMemberName() + " 님, 환영합니다!");
        }
        
        
        
        //쿠폰 자동 발급 및 스탬프 적립  
        couponDao = new CouponDAOImpl();
        List<Coupon> coupons = couponDao.searchByMember(member.getMemberID());

        int selectedDiscount = 0;

        if (coupons == null || coupons.isEmpty()) {
        	System.out.println();
        	System.out.println("------------------------------------------------------------------------------");
            System.out.println("보유 중인 쿠폰이 없습니다.");
        } else {
        	System.out.println("");
        	System.out.println("------------------------------------------------------------------------------");
            System.out.println("보유 중인 쿠폰:");
            for (int i = 0; i < coupons.size(); i++) {
                Coupon c = coupons.get(i);
                if (c.getValidUntil().compareTo(LocalDate.now().toString()) < 0) continue;

                System.out.printf(" - %d. %s (할인: %d원, 사용기한: %s)%s\n",
                    i + 1,
                    c.getCouponName(),
                    c.getDiscount(),
                    c.getValidUntil(),
                    c.getIsUsed() == 1 ? "[사용됨]" : ""
                );
            }

            System.out.println();
            System.out.println("사용하실 쿠폰의 번호를 입력해주세요. (사용 안 함은 0)");
            System.out.print("선택: ");
            couponChoice = Integer.parseInt(sc.nextLine());

            if (couponChoice > 0 && couponChoice <= coupons.size()) {
                Coupon chosen = coupons.get(couponChoice - 1);
                if (chosen.getIsUsed() == 1) {
                    System.out.println("이미 사용된 쿠폰입니다.");
                } else if (chosen.getValidUntil().compareTo(LocalDate.now().toString()) < 0) {
                    System.out.println("유효기간이 지난 쿠폰입니다.");
                } else {
                    selectedDiscount = chosen.getDiscount();
                    couponDao.updateUsage(chosen.getCouponNo(), 1);
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

            couponDao = new CouponDAOImpl();
            couponDao.insert(newCoupon);
            System.out.println();
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
        	    
        	 int quantity = o.getQuantity(); // ✅ 수량 가져오기
        	 if (quantity <= 0) quantity = 1;

             originalTotal += (m.getBasicPrice() + o.getExtraFee()) * quantity;
             
        }
        
        int finalTotal = originalTotal - selectedDiscount;
        
        if (finalTotal < 0) finalTotal = 0;

        System.out.println("\n결제 금액 요약");
        System.out.println("- 기존 금액: " + originalTotal + "원");
        System.out.println("- 할인 금액: " + selectedDiscount + "원");
        System.out.println("> 최종 결제 금액: " + finalTotal + "원");

        
        // 결제로 이동
//        System.out.println("\n결제를 진행합니다...");
//        try {
//            Thread.sleep(1500);
//            System.out.println(".");
//            Thread.sleep(1000);
//            System.out.println(". .");
//            Thread.sleep(700);
//            System.out.println(". . .");
//            Thread.sleep(1100);
//            System.out.println(". . . .");
//            Thread.sleep(700);
//            System.out.println(". . .");
//            Thread.sleep(700);
//            System.out.println(". .");
//            Thread.sleep(500);
//            System.out.println(".");
//        } catch (InterruptedException e) {
//            // 무시
//        }
//
//        System.out.println("결제가 완료되었습니다. 감사합니다!");
        try {
            boolean takeOut = true;  // 현재는 기본값 설정
            Integer usedCouponNo = null;
            
            if(couponChoice > 0 && couponChoice <= coupons.size()) {
            	Coupon chosen = coupons.get(couponChoice - 1);
                if (chosen.getIsUsed() == 1 && chosen.getValidUntil().compareTo(LocalDate.now().toString()) >= 0) {
                    usedCouponNo = chosen.getCouponNo();
                }
            }
            		
            OrderService orderService = new OrderService();
            Order order = orderService.createOrderFromCart(cart, member.getMemberID(), usedCouponNo, takeOut);
            orderService.saveOrder(order);

        } catch (Exception e) {
            System.out.println("[ERROR] 주문 저장 중 오류 발생");
            e.printStackTrace();
        }
        
        
        PaymentViewHB.directPay(cart);

        }catch(SQLException e) {
        	System.out.println("데이터베이스 오류");
        	e.printStackTrace();
        }
    }
}
