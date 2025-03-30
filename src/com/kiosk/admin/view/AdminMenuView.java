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
				break;
			case 3:
				// 상품 수정 화면
				break;
			case 4:
				// 상품 삭제 화면
				break;
			case 0:
				AdminMainView.adminMainMenu(); // 뒤로가기 (관리자 메인 메뉴 화면)
			}// end switch

		} //end while
		
	}//printAdminMenuManage
	
	
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

}//class
