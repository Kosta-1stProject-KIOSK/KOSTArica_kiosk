package com.kiosk.view;

import java.util.Map;

import com.kiosk.member.model.dto.Menu;
import com.kiosk.member.model.dto.MenuOption;

public class PaymentViewHB implements ConsoleColor {
	
	public static void directPay(Map<Menu, MenuOption> cart) {
		
        int total = 0;
        System.out.println();
    	System.out.println("╔══════════════════ 주문 요약 ══════════════════╗");                    	
        for (Map.Entry<Menu, MenuOption> entry : cart.entrySet()) {
            Menu m = entry.getKey();
            MenuOption o = entry.getValue();
            int quantity = o.getQuantity();
            if (quantity <= 0) quantity = 1;
            
            int itemPrice = (m.getBasicPrice() + o.getExtraFee()) * quantity;
            total += itemPrice;
            
            System.out.println("- " + m.getMenuName() + " x " + quantity + "잔 (" + itemPrice + "원)");
        }

    	System.out.println("﻿╚═══════════════════════════════════════════════╝");


        
        
        
        try {
			Thread.sleep(1400);
	        System.out.println(".");
	        Thread.sleep(1200);
	        System.out.println(". .");
	        Thread.sleep(1000);
	        System.out.println(". . .");
	        Thread.sleep(800);
	        System.out.println(". . . .");
	        Thread.sleep(500);
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        System.out.println("*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*");
	        System.out.println("                        메인 화면으로 돌아갑니다.                    ");
	        System.out.println("*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*:◆:*:◇:*");
	        Thread.sleep(1000);
	        System.out.print("3 ");
	        Thread.sleep(1000);
	        System.out.print("2 ");
	        Thread.sleep(1000);
	        System.out.print("1 ");
	        Thread.sleep(1000);
	        System.out.print("... ");
        } catch (InterruptedException e) {
        }

     
    }
	
	
	
	
}
