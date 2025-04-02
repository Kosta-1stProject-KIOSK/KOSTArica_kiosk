package com.kiosk.member.service;

import java.util.Scanner;

import com.kiosk.member.model.dto.Menu;
import com.kiosk.member.model.dto.MenuOption;
import com.kiosk.view.ConsoleColor;

public class OrderFlowService implements ConsoleColor {

	private final Scanner sc = new Scanner(System.in);
	
	public MenuOption selectOption(Menu menu) {
		
		if(menu.getCategoryName().equalsIgnoreCase("푸드")) {
			
			System.out.println("\n" + menu.getMenuName() + " (" + menu.getBasicPrice() + "원)");
	        System.out.print("수량을 입력해주세요: ");
	        int quantity = Integer.parseInt(sc.nextLine());

	        int totalPrice = menu.getBasicPrice() * quantity;
	        System.out.println("총 가격: " + totalPrice + "원");

	        System.out.println("\n장바구니에 담기[#] / 뒤로가기[<]");
	        String confirm = sc.nextLine();
	        if (confirm.equals("#")) {
	            return new MenuOption(0, menu.getMenuNo(), "-", "-", 0, 0, 0, quantity);  // 옵션 없는 값으로 채움
	        } else {
	            return null;
	        }
		}
		
		System.out.println("\n" + menu.getMenuName() + " (" + menu.getBasicPrice() + "원)");
		System.out.println(menu.getDescription());
		
		int extraFee = 0;
        
        
		
        // 온도
        String temperature = "";
        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
        		         + "┊ ┊ ┊ ┊ ┊ ┊\r\n"
		        		  +"┊ ┊ ┊ ┊ ˚✩ ⋆｡˚ ✩  "+bYELLOW+BOLD+"★ 온도를 선택하시오\r\n"
		           +RESET+ "┊ ┊ ┊ ✫\r\n"
		        		  +"┊ ┊ ︎✧		 [1] HOT\r\n"
		        		  +"┊ ┊ ✯		 [2] ICE\r\n"
		        		 + "┊ . ˚ ˚✩\r\n"
		         	     + "▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
		         		 + "\r\n"
		         		 + "선택 >>");
       
        int tempChoice = Integer.parseInt(sc.nextLine());
        temperature = tempChoice == 1 ? "HOT" : "ICE";

        
        // 사이즈
        String size = "";
        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
        		+ "┊ ┊ ┊ ┊ ┊ ┊\r\n"
        		+ "┊ ┊ ┊ ┊ ˚✩ ⋆｡˚ ✩  "+bYELLOW+BOLD+"★ 사이즈를 선택하시오\r\n"
        		+ RESET+"┊ ┊ ┊ ✫\r\n"
        		+ "┊ ┊ ︎✧		 [1] S (+0   원)\r\n"
        		+ "┊ ┊ ✯		 [2] M (+800 원)\r\n"
        		+ "┊ .˚ ˚✩		 [3] L (+1600원)\r\n"
        		+ "▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
        		+ "\r\n"
        		+ "선택 >>");

        int sizeChoice = Integer.parseInt(sc.nextLine());
        
        switch (sizeChoice) {
            case 1: size = "S"; break;
            case 2: size = "M"; extraFee += 800; break;
            case 3: size = "L"; extraFee += 1600; break;
        }

        
        // 샷 추가
        int shot = 0;
        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
        		+ "┊ ┊ ┊ ┊ ┊ ┊\r\n"
        		+ "┊ ┊ ┊ ┊ ˚✩ ⋆｡˚ ✩  "+bYELLOW+BOLD+"★ 샷추가를 선택하시오\r\n"
        		+ RESET+"┊ ┊ ┊ ✫\r\n"
        		+ "┊ ┊ ︎✧		 [0] 기본(+0   원)\r\n"
        		+ "┊ ┊ ✯		 [1] +1샷(+600 원)\r\n"
        		+ "┊ .˚ ˚✩		 [2] +2샷(+1200원)\r\n"
        		+ "▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
        		+ "\r\n"
        		+ "선택 >>");

        shot = Integer.parseInt(sc.nextLine());
        extraFee += shot * 600;

        
        // 휘핑
        int whipping = 0;
        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
        		+ "┊ ┊ ┊ ┊ ┊ ┊\r\n"
        		+"┊ ┊ ┊ ┊ ˚✩ ⋆｡˚ ✩  "+bYELLOW+BOLD+"★ 휘핑크림 유무를 선택하시오\r\n"
        		+RESET+ "┊ ┊ ┊ ✫\r\n"
        		+"┊ ┊ ︎✧		 [0] 선택안함(+0   원)\r\n"
        		+"┊ ┊ ✯		 [1] 휘핑추가(+600 원)\r\n"
        		+ "┊ .˚ ˚✩\r\n"
        		+ "▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
        		+ "\r\n"
        		+ "선택 >>");

        whipping = Integer.parseInt(sc.nextLine());
        if (whipping == 1) extraFee += 600;

        
        // 수량
        System.out.println("▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
        		+"┊ ┊ ┊ ┊ ˚✩ ⋆｡˚ ✩ \r\n"
        		+ "┊ ┊ ┊ ✫		  "+bYELLOW+BOLD+"★ 수량을 입력하시오\r\n"
        		+RESET+"┊ ┊ ︎✧	\r\n"
        		+ "┊ . ˚ ˚✩\r\n"
        		+ "▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃\r\n"
        		+ "\r\n"
        		+ "선택 >>");
        int quantity = Integer.parseInt(sc.nextLine());

        
        // 최종 출력
        int totalPrice = (menu.getBasicPrice() + extraFee) * quantity;
        
        System.out.println();        
        System.out.println("╭────────────────────────.★..─╮");
        System.out.println(BOLD+"\n" +"	"+ menu.getMenuName());
        System.out.println("	- " + temperature);
        if (!size.equals("")) System.out.println("	- " + size);
        if (shot > 0) System.out.println("	- +" + shot + "샷");
        if (whipping == 1) System.out.println("	- 휘핑크림 추가");
        System.out.println("	- 수량: " + quantity);
        System.out.println(tGREEN+"		가격: " + totalPrice + "원"+RESET);
        System.out.println();
        System.out.println("╰─..★.────────────────────────╯");

        System.out.println();
        System.out.println(bWHITE+tBLACK+"		장바구니에 담기[#]		|	  뒤로가기[<]     	"+RESET);
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
