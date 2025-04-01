package com.kiosk.view;

public class SuccessView {

	public static void show(String message) {
        System.out.println("\n[성공] " + message);
    }

    public static void showOrderComplete() {
        System.out.println("\n==============================");
        System.out.println("결제가 성공적으로 완료되었습니다.");
        System.out.println("영수증이 출력되었습니다.");
        System.out.println("주문해주셔서 감사합니다!");
        System.out.println("==============================\n");
    }
}
