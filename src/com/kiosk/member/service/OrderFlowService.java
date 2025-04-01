package com.kiosk.member.service;

import java.util.Scanner;

import com.kiosk.member.model.dto.Menu;
import com.kiosk.member.model.dto.MenuOption;

public class OrderFlowService {

	private final Scanner sc = new Scanner(System.in);
	
	public MenuOption selectOption(Menu menu) {
		
		System.out.println("\n" + menu.getMenuName() + " (" + menu.getBasicPrice() + "원)");
		System.out.println(menu.getDescription());
		
		int extraFee = 0;
        
        
		
        // 온도
        String temperature = "";
        System.out.println("\n1. 온도 선택");
        System.out.println("- HOT[1]");
        System.out.println("- ICE[2]");
        System.out.print("선택: ");
        int tempChoice = Integer.parseInt(sc.nextLine());
        temperature = tempChoice == 1 ? "HOT" : "ICE";

        
        // 사이즈
        String size = "";
        System.out.println("\n2. SIZE 선택 (추가금액 있음)");
        System.out.println("- S[1] (+0    원");
        System.out.println("- M[2] (+800  원)");
        System.out.println("- L[3] (+1600 원)");
        System.out.print("선택: ");
        int sizeChoice = Integer.parseInt(sc.nextLine());
        
        switch (sizeChoice) {
            case 1: size = "S"; break;
            case 2: size = "M"; extraFee += 800; break;
            case 3: size = "L"; extraFee += 1600; break;
        }

        
        // 샷 추가
        int shot = 0;
        System.out.println("\n3. 샷 추가 선택");
        System.out.println("- 기본[0] (+0   원)");
        System.out.println("- +1샷[1] (+600 원)");
        System.out.println("- +2샷[2] (+1200원)");
        System.out.print("선택: ");
        shot = Integer.parseInt(sc.nextLine());
        extraFee += shot * 600;

        
        // 휘핑
        int whipping = 0;
        System.out.println("\n4. 휘핑크림 선택");
        System.out.println("- 선택안함[0] (+0  원)");
        System.out.println("- 휘핑추가[1] (+600원)");
        System.out.print("선택: ");
        whipping = Integer.parseInt(sc.nextLine());
        if (whipping == 1) extraFee += 600;

        
        // 수량
        System.out.print("\n수량: ");
        int quantity = Integer.parseInt(sc.nextLine());

        
        // 최종 출력
        int totalPrice = (menu.getBasicPrice() + extraFee) * quantity;
        
        System.out.println("\n" + menu.getMenuName());
        System.out.println("- " + temperature);
        if (!size.equals("")) System.out.println("- " + size);
        if (shot > 0) System.out.println("- +" + shot + "샷");
        if (whipping == 1) System.out.println("- 휘핑크림 추가");
        System.out.println("- " + quantity + "잔");
        System.out.println("총 가격: " + totalPrice + "원");

        System.out.println("\n장바구니에 담기[#] / 뒤로가기[<]");
        String confirm = sc.nextLine();
        if (confirm.equals("#")) {
        	MenuOption option = new MenuOption(0, menu.getMenuNo(), temperature, size, shot, whipping, extraFee, 0);
            option.setQuantity(quantity); 
            return option;
        } else {
            return null; 
        }
    
        
	}
	
	
	
}//class
