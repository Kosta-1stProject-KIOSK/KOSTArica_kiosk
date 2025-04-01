package com.kiosk.admin.view;

import java.util.Scanner;

import com.kiosk.admin.controller.AdminloginController;
import com.kiosk.view.MainMenuView;

/**
 * 관리자 모드 진입 시 메인 화면 View
 */
public class AdminMainView {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * 관리자 로그인 메뉴
	 */
	public static void adminLogin() {
		System.out.print("관리자 아이디를 입력하세요 : ");
		String adminId = sc.nextLine();

		System.out.print("비밀번호를 입력하세요 : ");
		String adminPw = sc.nextLine();

		AdminloginController.login(adminId, adminPw);
	}// login

	/**
	 * 관리자 메인화면 메뉴를 출력하는 메소드
	 */
	public static void printAdminMain() {
		System.out.println("════════════════════════ KOSTArica Cafe '관리자모드'입니다. 메뉴를 선택하세요══════════════════════════════");
		System.out.println("|	[1] 메뉴관리	| 	[2] 쿠폰관리	|	[3] 통계조회	|	[0] 뒤로가기	|");
		System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════");
	}// printMainMenu

	/**
	 * 관리자 메뉴를 부르는 메소드
	 */
	public static void adminMainMenu() {
		while (true) {
			printAdminMain(); // 관리자 메인화면 출력

			System.out.print("선택 > ");
			int input = Integer.parseInt(sc.nextLine()); // 입력 받기

			switch (input) {
			case 1:
				AdminMenuView.printAdminMenuManage();
				break;
			case 2:
				// 쿠폰관리 메인화면
				AdminCouponView.printAdminCouponManage();
				break;
			case 3:
				// 통계관리 메인화면
				AdminStatsView.printAdminStatsManage();
				break;
			case 0:
				MainMenuView.mainMenu(); // 뒤로가기 (모드선택 화면)
			}// end switch

		} // end while
	}// mainMenu

}// class
