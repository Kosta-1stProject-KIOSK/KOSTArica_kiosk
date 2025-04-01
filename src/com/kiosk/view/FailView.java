package com.kiosk.view;

public class FailView {

	public static void show(String message) {
        System.out.println("\n[실패] " + message);
    }

    public static void showOrderFail() {
        System.out.println("\n==============================");
        System.out.println("결제에 실패하였습니다.");
        System.out.println("다시 시도해 주세요.");
        System.out.println("==============================\n");
    }
}
