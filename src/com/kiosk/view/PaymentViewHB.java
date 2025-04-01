package com.kiosk.view;

import java.util.Map;

import com.kiosk.member.model.dto.Menu;
import com.kiosk.member.model.dto.MenuOption;

public class PaymentViewHB {
	
	public static void directPay(Map<Menu, MenuOption> cart) {
		
        int total = 0;
        
        for (Map.Entry<Menu, MenuOption> entry : cart.entrySet()) {
            Menu m = entry.getKey();
            MenuOption o = entry.getValue();
            total += m.getBasicPrice() + o.getExtraFee();
        }

        System.out.println("\n결제를 진행합니다...");
        try {
            Thread.sleep(500); System.out.print(".");
            Thread.sleep(500); System.out.print(".");
            Thread.sleep(500); System.out.println(".");
        } catch (InterruptedException e) {
            // 생략
        }

        System.out.println("✅ 결제가 완료되었습니다.");
        System.out.println("총 결제 금액: " + total + "원");
        System.out.println("\n메인 화면으로 돌아갑니다.\n");
    }
	
	
	
	
}
