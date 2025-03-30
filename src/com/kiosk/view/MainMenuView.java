package com.kiosk.view;

import java.util.Scanner;

import com.kiosk.admin.view.AdminMainView;
import com.kiosk.member.view.memberView;

public class MainMenuView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 메인화면 메뉴를 부르는 메소드
	 */
	public static void mainMenu() {
		while(true) {
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
				System.exit(0); //콘솔 종료
			}//end switch
			
		}//end while
	}//mainMenu
	
	
	
	/**
	 * 메인화면 메뉴를 출력하는 메소드
	 */
	public static void printMainMenu() {
		System.out.println("========= KOSTArica Cafe 입니다. 입장하시겠습니까? =========");
		System.out.println("1. 카페이용하기	| 2. 관리자모드	|	0. 종료");
	}//printMainMenu
	
	
	
}//class
