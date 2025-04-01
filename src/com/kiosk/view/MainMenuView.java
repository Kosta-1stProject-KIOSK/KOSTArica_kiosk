package com.kiosk.view;

import java.util.List;
import java.util.Scanner;

import com.kiosk.admin.controller.AdminMenuController;
import com.kiosk.admin.view.AdminMainView;
import com.kiosk.member.view.memberView;

public class MainMenuView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 메인화면 메뉴를 부르는 메소드
	 */
	public static void mainMenu() {
		while(true) {
			System.out.println("======================================================================");
	        System.out.println();
			System.out.println(" ██╗  ██╗ ██████╗ ███████╗████████╗ █████╗ ██████╗ ██╗ ██████╗ █████╗ ");
	        System.out.println(" ██║ ██╔╝██╔═══██╗██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██║██╔════╝██╔══██╗");
	        System.out.println(" █████╔╝ ██║   ██║███████╗   ██║   ███████║██████╔╝██║██║     ███████║");
	        System.out.println(" ██╔═██╗ ██║   ██║╚════██║   ██║   ██╔══██║██╔═██╗ ██║██║     ██╔══██║");
	        System.out.println(" ██║  ██╗╚██████╔╝███████║   ██║   ██║  ██║██║	██╗██║╚██████╗██║  ██║");
	        System.out.println(" ╚═╝  ╚═╝ ╚═════╝ ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝╚═╝  ╚═╝");
	        System.out.println("        ⠀⠀⠀⠀⠀⠀⠀⠀⠀          ⡀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
	        System.out.println("                  ⠀⠀⠀⠀⠀⠀⠀⢜⢕⡝⣜⢭⢫⠒⡠⣴⣲⢯⡿⣽⠻⢓⣀⡀⠀⠀⠀");
	        System.out.println("                  ⠀⠀⠀⠀⠀⢀⢵⠈⢕⢵⡱⠕⣁⣮⣟⣗⣯⢿⠝⢁⣼⢯⡯⡿⡄⠀⠀");
	        System.out.println("                  ⠀⠀⠀⠀⠀⢘⡜⣕⢄⡈⠊⣸⣞⣗⣟⡾⣽⠋⣠⢿⣺⢯⢿⡽⡇⠀⠀⠀");
	        System.out.println("             ⠀⠀⠀⠀     ⠀⠐⡕⣇⢗⠕⣰⣟⣞⡷⡯⡿⡍⣠⢿⡽⣽⢯⢿⢽⠁⠀⠀⠀");
	        System.out.println("             ⠀     ⠀⠀⠀⠀⠀⠑⡕⡧⠡⣷⣻⢾⢽⡯⠏⢠⢾⢯⢿⣝⣯⢿⠁⠀⠀⠀⠀⠀");
	        System.out.println("          ⠀        ⠀⠀⠀⠀⠀⠀⠈⠪⠨⡾⣞⣯⠿⠉⣔⣟⣯⢿⡽⡾⠝⠀⠀⠀⠀⠀⠀⠀⠀");
	        System.out.println("          ⠀⠀⠀        ⠀⠀⠀⠀⠀⠀⠀⠈⠉⡨⡴⣯⢯⡷⡻⠝⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
	        System.out.println();
		    System.out.println("======================================================================");
			System.out.println();
		    System.out.println("                        [ 신메뉴 출시 ]	");
		    System.out.println();
		    System.out.print("            ");
		    AdminMenuController.searchNewMenu();
		    System.out.println();
		    System.out.println();
		    System.out.println("                      [ BEST 메뉴 추천 ]	");
		    System.out.println();
		    AdminMenuController.searchBestMenu();
			printMainMenu(); //메인화면 메뉴 출력
			
			System.out.print("선택 > ");
			int input = Integer.parseInt(sc.nextLine()); //입력 받기
			
			switch(input) {
			case 1 :
				memberView.cafeMenu(); //카페이용 메인화면
				break;
			case 2 :
				AdminMainView.adminLogin(); //관리자 로그인 화면
				break;
			case 0 :
				AdminMenuController.updateCapacity();
				System.exit(0); //콘솔 종료
			}//end switch
			
		}//end while
	}//mainMenu
	
	
	
	/**
	 * 메인화면 메뉴를 출력하는 메소드
	 */
	public static void printMainMenu() {
		System.out.println("============== KOSTArica Cafe 입니다. 입장하시겠습니까? ===============");
		System.out.println("      1. 카페이용하기       |       2. 관리자모드       |       0. 종료");
	}//printMainMenu
	
	/**
	 * 신메뉴 출력
	 */
	public static void printNewMenuList(List<String> list) {
		for(String menu : list) {
			System.out.print("NEW! " + menu + "    ");
		}//end for
		
		System.out.println();
	}
	
	/**
	 * 베스트 메뉴 출력
	 */
	public static void printBestMenuList(List<String> list) {
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("                      " + (i+1) + "위." + list.get(i) + "    ");
			System.out.println();
		}
		
		System.out.println();
	}
	
	
	
}//class
