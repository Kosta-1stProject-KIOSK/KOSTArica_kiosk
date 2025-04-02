package com.kiosk.member.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.kiosk.member.model.dto.Menu;
import com.kiosk.member.model.dto.MenuOption;
import com.kiosk.member.service.MenuSelectService;
import com.kiosk.member.service.OrderFlowService;
import com.kiosk.view.ConsoleColor;
import com.kiosk.view.MemberCouponViewHB;
import com.kiosk.view.PaymentViewHB;

public class KioskController implements ConsoleColor {

	private final MenuSelectService menuService = new MenuSelectService();
	private final OrderFlowService orderService = new OrderFlowService();
	
	private final Scanner sc = new Scanner(System.in);
	private final Map<Menu, MenuOption> orderCart = new LinkedHashMap<>();
	
	
	public void startOrder() {
		
		while(true) {
			
			Menu selectedMenu = menuService.startMenuSelection();
            if (selectedMenu == null) {
                return;
            }
            
            MenuOption option = orderService.selectOption(selectedMenu);
            if (option == null) {
                System.out.println("옵션 선택을 취소하였습니다.");
                continue;
            }
            
            orderCart.put(selectedMenu, option);
            System.out.println();
            System.out.println();
            System.out.println();
                    System.out.println(bCYAN+"		    장바구니에 담았습니다.                                                 "+RESET);
            System.out.println();
               System.out.println("╭╼|════════════════════════════════════════════════|╾╮\r\n"
            		+ BOLD+ "	           	"+bMAGENTA+"다음 작업을 선택하세요\r\n"
            		+ RESET+ BOLD+"\r\n"
            		+ "	        [1] 주문 계속하기\r\n"
            		+ "	        [2] 결제 진행하기\r\n"
            		+ "	        [3] 주문 취소하기\r\n"
            		+ "╰╼|════════════════════════════════════════════════|╾╯");
            System.out.print("선택: ");
            String action = sc.nextLine();
            
            switch (action) {
            case "1":
                continue;
            case "2":
            	System.out.println();
                System.out.println("╭╼|════════════════════════════════════════════════|╾╮\r\n"
                		+ BOLD+ "	           	"+bMAGENTA+"결제 옵션\r\n"
                		+ RESET+ BOLD+"\r\n"
                		+ "	        [1] 적립 및 쿠폰 사용\r\n"
                		+ "	        [2] 바로 결제\r\n"
                		+ "	        [3] 이전으로\r\n"
                		+ "╰╼|════════════════════════════════════════════════|╾╯");
                System.out.print("선택: ");
                String payOption = sc.nextLine();

                switch (payOption) {
                    case "1": //적립
                        MemberCouponViewHB.handleMemberFlow(orderCart);
                        startOrder();
                        continue;
                        
                    case "2": //바로결제
                    	System.out.println();
                    	System.out.println("╔══════════════════ 주문 요약 ══════════════════╗");                    	
                    	for (Map.Entry<Menu, MenuOption> entry : orderCart.entrySet()) {
                            Menu menu = entry.getKey();
                            MenuOption opt = entry.getValue();
                            
                            int quantity = opt.getQuantity();
                            if (quantity <= 0) quantity = 1;
                            
                            int total = (menu.getBasicPrice() + opt.getExtraFee()) * quantity;

                            System.out.println("	- " + menu.getMenuName() + " x " + quantity + "잔 (" + total + "원)");
                        }
                    	System.out.println("﻿╚═══════════════════════════════════════════════╝");
                    	System.out.println();
                        System.out.print(bWHITE+tBLACK+"위 내용으로 결제하시겠습니까? [Y/N]: "+RESET);
                        String confirm = sc.nextLine().trim().toUpperCase();
                        if (confirm.equals("Y")) {
                            PaymentViewHB.directPay(orderCart);
                        } else {
                            System.out.println("결제가 취소되었습니다.");
                        }
                        
                        startOrder();
                        continue;
                        
                    case "0": //이전으로
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

