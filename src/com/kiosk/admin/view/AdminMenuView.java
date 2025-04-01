package com.kiosk.admin.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.kiosk.admin.controller.AdminCouponController;
import com.kiosk.admin.controller.AdminMenuController;
import com.kiosk.admin.model.dto.Menu;
import com.kiosk.util.InputValid;

/**
 * 관리자모드 > 메인 화면 > 메뉴 관리 View
 */
public class AdminMenuView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 메뉴 관리 메인 화면 출력
	 */
	public static void printAdminMenuManage() {
		System.out.println();
		System.out.println();
		System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════");
		System.out.println("				메뉴 관리 페이지입니다. 무엇을 하시겠습니까?");
		System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════");


		while (true) {
			System.out.println("-------------------------------------------메뉴 관리----------------------------------------------");
			System.out.println("    [1] 조회	  |     [2] 등록     |     [3] 수정     |     [4] 삭제     |    [0] 뒤로가기");
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
		AdminMenuController.searchMenuName();
//		System.out.print("메뉴 이름을 입력하세요 : ");
//		String menuName = sc.nextLine();
		String menuName = InputValid.getStringInput("메뉴 이름을 입력하세요: ");
		
//		System.out.print("가격을 입력하세요 : ");
//		int basicPrice = sc.nextInt();
		int basicPrice = InputValid.getNumberInput("가격을 입력하세요: ");
		
//		System.out.print("설명을 입력하세요 : ");
//		String description = sc.nextLine();
		String description = InputValid.getShortDescription("설명을 입력하세요 : ");
		
//		System.out.print("현재 잔여 수량을 입력하세요 : ");
//		int capacity = sc.nextInt();
		int capacity = InputValid.getNumberInput("현재 잔여 수량을 입력하세요: ");
		
		System.out.println("해당하는 카테고리 번호를 입력하세요.");
		System.out.println("1. 커피	|	2. 논커피	|	3. 푸드");
		System.out.print("카테고리 번호 : ");
		int categoryNo = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 비우기;
		
		Menu menu = new Menu(menuName, basicPrice, description, capacity, categoryNo);
		AdminMenuController.insertMenu(menu);
		sc.nextLine(); // 개행 문자 제거 (다른 입력이 있을 경우 대비)
		
	}//printInsertProcess
	
	/**
	 * 메뉴 수정 Process View
	 */
	public static void printUpdateProcess() {
		AdminMenuController.searchMenuName();
		int menuNo = InputValid.getNumberInput("수정하려는 상품 번호를 입력하세요 : ");
		
//		System.out.print("수정하려는 가격을 입력하세요 : ");
		int basicPrice = InputValid.getNumberInput("수정하려는 가격을 입력하세요 : ");
		
//		System.out.print("수정하려는 설명을 입력하세요 : ");
		String description = InputValid.getShortDescription("수정하려는 설명을 입력하세요 : ");
		
//		System.out.print("현재 잔여 수량을 수정하세요 : ");
		int capacity = InputValid.getNumberInput("현재 잔여 수량을 수정하세요 : ");
		
		//판매여부 조회
		int menuIsActive = AdminMenuController.searchIsActive(menuNo);
	    String isActiveStatus = (menuIsActive == 1) ? "판매중" : "판매중지";
	    System.out.println("현재 판매여부: " + isActiveStatus);
		
	    //사용자에게 판매여부 변경 여부 확인
	    String userInput = InputValid.getYesOrNoInput("판매여부를 변경하시겠습니까? (Y/N): ");
	    
	    //사용자 입력에 따라 판매여부 수정
	    if (userInput.equalsIgnoreCase("Y")) {
	        // 판매여부를 반전시킴 (0 -> 1, 1 -> 0)
	        menuIsActive = (menuIsActive == 1) ? 0 : 1;
	    }
		
		Menu menu = new Menu(menuNo, basicPrice, description, capacity, menuIsActive);
		AdminMenuController.updateMenu(menu);
		
	}//printUpdateProcess
	
	/**
	 * 메뉴 삭제 Process View
	 */
	public static void printDeleteProcess() {
		AdminMenuController.searchMenuName();
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
		System.out.println("-----------------------------메뉴 " + list.size() + "개 ----------------------------");
		System.out.println("메뉴번호 | 메뉴이름 | 가격 | 설명 |  등록일 | 재고 | 사용여부 | 카테고리");
		for(Menu menu : list) {
			System.out.println(menu);
		}//end for
		
		System.out.println();
	}
	
	/**
	 * 메뉴번호와 메뉴명 출력
	 * @param list
	 */
	public static void printMenuNameList(List<Menu> list) {
		System.out.println("------------------- [현재 메뉴] -------------------");
		// 메뉴 번호(menuNo) 기준으로 정렬
	    Collections.sort(list, Comparator.comparingInt(Menu::getMenuNo));
		
		for (int i = 0; i < list.size(); i++) {
	        System.out.print(list.get(i).getMenuNo() + ". " + list.get(i).getMenuName() + " ");

	        // 5개 출력할 때마다 줄바꿈
	        if ((i + 1) % 5 == 0) {
	            System.out.println(); // 중복 출력 제거
	        }
	    }

	    // 남은 메뉴가 5개 미만일 경우 줄바꿈
	    if (list.size() % 5 != 0) {
	        System.out.println();
	    }
	    
		System.out.println("-------------------------------------------------");
		
		
//		for(Menu menu : list) {
//			System.out.print(menu.getMenuNo() + ". " + menu.getMenuName() + " ");
//		}//end for
		
		System.out.println();
	}
	
	/**
	 * 단순 출력 메소드
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}

}//class
