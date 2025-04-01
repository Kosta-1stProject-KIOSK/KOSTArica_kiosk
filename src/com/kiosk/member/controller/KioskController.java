package com.kiosk.member.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.kiosk.member.model.dto.Menu;
import com.kiosk.member.model.dto.MenuOption;
import com.kiosk.member.service.MenuSelectService;
import com.kiosk.member.service.OrderFlowService;
import com.kiosk.view.MemberCouponViewHB;
import com.kiosk.view.PaymentViewHB;

public class KioskController {

	private final MenuSelectService menuService = new MenuSelectService();
	private final OrderFlowService orderService = new OrderFlowService();
	
	private final Scanner sc = new Scanner(System.in);
	private final Map<Menu, MenuOption> orderCart = new LinkedHashMap<>();
	
	
	public void startOrder() {
		
		while(true) {
			Menu selectedMenu = menuService.returnMenu();
            if (selectedMenu == null) {
                System.out.println("메뉴 선택을 취소하였습니다.");
                continue;
            }
            
            
            MenuOption option = orderService.selectOption(selectedMenu);
            if (option == null) {
                System.out.println("옵션 선택을 취소하였습니다.");
                continue;
            }
            
            
            orderCart.put(selectedMenu, option);
            System.out.println("장바구니에 담았습니다.");
            System.out.println();
            System.out.println("다음 작업을 선택하세요:");
            System.out.println("[1] 주문 계속하기");
            System.out.println("[2] 결제 진행하기");
            System.out.println("[0] 주문 취소하기");
            System.out.print("선택: ");
            String action = sc.nextLine();
            
            
            switch (action) {
            case "1":
                continue;
                
            case "2":
                System.out.println("\n--- 결제 옵션 ---");
                System.out.println("[1] 적립 및 쿠폰 사용");
                System.out.println("[2] 바로 결제");
                System.out.println("[0] 이전으로");
                System.out.print("선택: ");
                String payOption = sc.nextLine();

                switch (payOption) {
                    case "1":
                        MemberCouponViewHB.handleMemberFlow(orderCart);
                        return;
                    case "2":
                        PaymentViewHB.directPay(orderCart);
                        return;
                    case "0":
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
                break;
                
            case "0":
                System.out.println("주문을 초기화하고 메인으로 돌아갑니다.");
                return;
            default:
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
        }//switch
            
		}//while
		
		
	}
	
	

	
	
}//class

