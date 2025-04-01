package com.kiosk.admin.view;

import java.util.List;
import java.util.Scanner;

import com.kiosk.admin.controller.AdminStatsController;
import com.kiosk.admin.model.dto.Stats;
import com.kiosk.util.InputValid;
import com.kiosk.view.ConsoleColor;

/**
 * 관리자모드 > 메인화면 > 통계조회 View
 */
public class AdminStatsView implements ConsoleColor {
	private static Scanner sc = new Scanner(System.in);
	
	public static void printAdminStatsManage() {
		System.out.println();
		System.out.println();

		while (true) {
			System.out.println();
			System.out.println("════════════════════════════════════════════════════════════════════════");
			System.out.println("		통계 조회 페이지입니다. 무엇을 하시겠습니까?");
			System.out.println("════════════════════════════════════════════════════════════════════════");
			System.out.println(bWHITE+tBLACK+"  [1]메뉴별 판매 | [2]총매출 | [3]시간대별 주문 | [4]지난 비교 | [0]뒤로    "+RESET);
			int input = InputValid.getNumberInput("선택 ▶ ");
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				//메뉴별 판매 수
				printMenuSalesProcess();
				break;
			case 2:
				// 총 매출
				AdminStatsController.getTotalSales();
				break;
			case 3:
				// 시간대별 주문 수
				printSalesTimeProcess();
				break;
			case 4:
				// 지난 매출 비교
				printSalesCompareProcess();
				break;
			case 0:
				AdminMainView.adminMainMenu(); // 뒤로가기 (관리자 메인 메뉴 화면)
			}// end switch

		} //end while
		
	}//printAdminStatsManage
	
	
	////////////////////////////Process View//////////////////////////
	/**
	 * 메뉴별 판매수  Process View
	 */
	public static void printMenuSalesProcess() {
		System.out.println("***************************** [ 메뉴별 판매 수 ] *******************************");
		System.out.println(bWHITE+tBLACK+"   [1] 일간 조회   |   [2] 주간 조회   |   [3] 월간 조회   |   [0] 뒤로   "  +RESET);
		System.out.print("선택 ▶ ");
		int input = Integer.parseInt(sc.nextLine());
		
		if(input == 0) {
			printAdminStatsManage();
		} else {
			AdminStatsController.MenuSales(input);
		}
	}// printInsertProcess
	
	/**
	 * 시간대별 주문수  Process View
	 */
	public static void printSalesTimeProcess() {
		System.out.println("************************** [ 시간대별 주문 수 ] **********************************");
		System.out.println(bWHITE+tBLACK+"      [1] 일간 조회       |       [2] 주간 조회       |       [0] 뒤로        "+RESET);
		System.out.print("선택 > ");
		int input = Integer.parseInt(sc.nextLine());
		
		if(input == 0) {
			printAdminStatsManage();
		} else {
			AdminStatsController.SalesTime(input);
		}
	}// printInsertProcess
	
	/**
	 * 지난 매출과 비교  Process View
	 */
	public static void printSalesCompareProcess() {
		System.out.println("***************************** [ 지난 매출과 비교 ] *******************************");
		System.out.println(bWHITE+tBLACK+"        [1] 주간        |        [2] 월간        |        [0] 뒤로       "+RESET);
		System.out.print("선택 ▶ ");
		int input = Integer.parseInt(sc.nextLine());
		
		if(input == 0) {
			printAdminStatsManage();
		} else {
			AdminStatsController.salesCompare(input);;
		}
	}// printInsertProcess
	
	
	
	////////////////////////////End View//////////////////////////
	
	
	/**
	 * 조회 후 출력
	 */
	public static void printStatsList(List<Stats> list) {
		for(Stats stats : list) {
			System.out.println(stats);
		}//end for
		
		System.out.println();
	}
	
	/**
	 * 메뉴별 판매 수 출력
	 */
	public static void printMenuSalesList(List<Stats> list, int period) {
		System.out.println();
		System.out.println();
		System.out.println("==================================================================================");
	    System.out.println("                             메뉴 판매 통계 (" + (period == 1 ? "일간" : period == 2 ? "주간" : "월간") + ")");
	    System.out.println("==================================================================================");
	    System.out.println();
	    for (Stats stats : list) {
	        System.out.println("                    [" + stats.getRank() + "위] " + stats.getMenuName() + ", 판매 수량: " + stats.getQuantitySold());
	    }
	    System.out.println();
	    System.out.println("=================================================================================");
	}
	
	/**
	 * 전체 총 매출 출력
	 */
	public static void printTotalSales(Stats stats) {
		System.out.println();
		System.out.println();
	    System.out.println("=================================================================================");
	    System.out.println("                                   총 매출");
	    System.out.println("=================================================================================");
	    System.out.println();
	    System.out.println("                            [ 일간 ] " + stats.getTotalDaily() + " 원");
	    System.out.println("                            [ 주간 ] " + stats.getTotalWeekly() + " 원");
	    System.out.println("                            [ 월간 ] " + stats.getTotalMonthly() + " 원");
	    System.out.println();
	    System.out.println("=================================================================================");
	}
	
	/**
	 * 시간대별 주문 수 출력
	 */
	public static void printSalesTimeList(List<Stats> list, int period) {
		System.out.println();
		System.out.println();
	    System.out.println("=================================================================================");
	    System.out.println("                         시간대별 주문 수 (" + (period == 1 ? "일간" : "주간") + ")");
	    System.out.println("=================================================================================");

	    // 최대 주문 수 찾기
	    int maxSales = list.stream()
	                       .mapToInt(Stats::getTotalSales)
	                       .max()
	                       .orElse(1); // 주문이 하나도 없을 경우 대비

	    for (Stats stats : list) {
	        int squares = (int) ((stats.getTotalSales() / (double) maxSales) * 50); // 최대 50개까지 출력
	        System.out.printf("[%02d시] %3d개 %s%n", 
	                          stats.getOrderHour(), 
	                          stats.getTotalSales(), 
	                          "■".repeat(squares));
	    }

	    System.out.println("=================================================================================");
	}
	
	/**
	 * 지난 매출 비교 통계 조회
	 */
	public static void printSalesCompare(Stats stats, int period) {
		String str = period == 1 ? "주" : "달";
		System.out.println();
		System.out.println();
	    System.out.println("=================================================================================");
	    System.out.println("                              지난" + str + " 매출 비교");
	    System.out.println("=================================================================================");

	    System.out.println("                           [ 이번" + str + " ] " + stats.getOrderHour() + " 원");
	    System.out.println("                           [ 지난" + str + " ] " + stats.getTotalSales() + " 원");

	    System.out.println("=================================================================================");
	    
	    // 현재 값과 이전 값의 차이 계산
	    int difference = stats.getOrderHour() - stats.getTotalSales();
	    
	    // 차이 출력 (양수/음수에 따라 + 또는 - 기호 추가)
	    System.out.println("[ 매출 ] " + (difference >= 0 ? tRED + "+" + difference + "원" +RESET : tCYAN + "" + difference + "원" +RESET));
	}
	
	/**
	 * 단순 출력 메소드
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}

}
