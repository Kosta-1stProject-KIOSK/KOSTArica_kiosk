package com.kiosk.admin.view;

import java.util.List;
import java.util.Scanner;

import com.kiosk.admin.controller.AdminMenuController;
import com.kiosk.admin.model.dto.Menu;

/**
 * 관리자모드 > 메인 화면 > 메뉴 관리 View
 */
public class AdminMenuView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 메뉴 관리 메인 화면 출력
	 */
	public static void printAdminMenuManage() {
		System.out.println("========= 메뉴 관리 페이지입니다. 무엇을 하시겠습니까? =========");

		while (true) {
			System.out.println("---------------------------메뉴 관리--------------------------");
			System.out.println("1. 조회	|	2. 등록	|	3.수정	|	4.삭제	|	0. 뒤로가기");
			System.out.print("선택 > ");
			int input = Integer.parseInt(sc.nextLine());

			switch (input) {
			case 1:
				AdminMenuController.searchAll();
				break;
			case 2:
				// 상품 등록 화면
				printInsertProcess();
				break;
			case 3:
				// 상품 수정 화면
				printUpdateProcess();
				break;
			case 4:
				// 상품 삭제 화면
				printDeleteProcess();
				break;
			case 0:
				AdminMainView.adminMainMenu(); // 뒤로가기 (관리자 메인 메뉴 화면)
			}// end switch

		} //end while
		
	}//printAdminMenuManage
	
	////////////////////////////Process View//////////////////////////
	/**
	 * 메뉴 등록 Process View
	 */
	public static void printInsertProcess() {
		System.out.print("메뉴 이름을 입력하세요 : ");
		String menuName = sc.nextLine();
		
		System.out.print("가격을 입력하세요 : ");
		int basicPrice = sc.nextInt();
		sc.nextLine(); // 개행 문자 제거
		
		System.out.print("설명을 입력하세요 : ");
		String description = sc.nextLine();
		
		System.out.print("현재 잔여 수량을 입력하세요 : ");
		int capacity = sc.nextInt();
		sc.nextLine(); // 개행 문자 제거
		
		System.out.println("해당하는 카테고리 번호를 입력하세요.");
		System.out.println("1. 커피	|	2. 논커피	|	3. 푸드");
		System.out.print("카테고리 번호 : ");
		int categoryNo = sc.nextInt();
		
		Menu menu = new Menu(menuName, basicPrice, description, capacity, categoryNo);
		AdminMenuController.insertMenu(menu);
		sc.nextLine(); // 개행 문자 제거 (다른 입력이 있을 경우 대비)
		
	}//printInsertProcess
	
	/**
	 * 메뉴 수정 Process View
	 */
	public static void printUpdateProcess() {
		System.out.print("수정하려는 상품 번호를 입력하세요 : ");
		int menuNo = sc.nextInt();
		sc.nextLine(); // 개행 문자 제거
		
		System.out.print("수정하려는 가격을 입력하세요 : ");
		int basicPrice = sc.nextInt();
		sc.nextLine(); // 개행 문자 제거
		
		System.out.print("수정하려는 설명을 입력하세요 : ");
		String description = sc.nextLine();
		
		System.out.print("현재 잔여 수량을 수정하세요 : ");
		int capacity = sc.nextInt();
		sc.nextLine(); // 개행 문자 제거
		
		Menu menu = new Menu(menuNo, basicPrice, description, capacity);
		AdminMenuController.updateMenu(menu);
		
	}//printUpdateProcess
	
	/**
	 * 메뉴 삭제 Process View
	 */
	public static void printDeleteProcess() {
		System.out.print("삭제하려는 상품 번호를 입력하세요 : ");
		int menuNo = sc.nextInt();
		sc.nextLine(); // 개행 문자 제거
		
		AdminMenuController.deleteMenu(menuNo);
		
	}//printDeleteProcess
	
	////////////////////////////End View//////////////////////////
	
	
	/**
	 * 1. 조회 선택 시 전체 메뉴 출력
	 * @param list
	 */
	public static void printAllMenuList(List<Menu> list) {
		System.out.println("-------------메뉴 " + list.size() + "개 -------------");
		for(Menu menu : list) {
			System.out.println(menu);
		}//end for
		
		System.out.println();
	}
	
	/**
	 * 단순 출력 메소드
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}

}//class
