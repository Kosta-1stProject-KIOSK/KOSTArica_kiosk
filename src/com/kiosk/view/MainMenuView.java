package com.kiosk.view;

import java.util.List;
import java.util.Scanner;

import com.kiosk.admin.controller.AdminMenuController;
import com.kiosk.admin.view.AdminMainView;
import com.kiosk.member.view.memberView;

public class MainMenuView implements ConsoleColor {

	
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 메인화면 메뉴를 부르는 메소드
	 */
	public static void mainMenu() {
		while(true) {
	System.out.println(tYELLOW+"▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
	        System.out.println(bBROWN+tYELLOW+"									      ");
			System.out.println(" ██╗  ██╗ ██████╗ ███████╗████████╗ █████╗ ██████╗ ██╗ ██████╗ █████╗ ");
	        System.out.println(" ██║ ██╔╝██╔═══██╗██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██║██╔════╝██╔══██╗");
	        System.out.println(" █████╔╝ ██║   ██║███████╗   ██║   ███████║██████╔╝██║██║     ███████║");
	        System.out.println(" ██╔═██╗ ██║   ██║╚════██║   ██║   ██╔══██║██╔═██╗ ██║██║     ██╔══██║");
	        System.out.println(" ██║  ██╗╚██████╔╝███████║   ██║   ██║  ██║██║	██╗██║╚██████╗██║  ██║");
	        System.out.println(" ╚═╝  ╚═╝ ╚═════╝ ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝╚═╝  ╚═╝");
	        System.out.println("								      "+RESET);
	System.out.println(tYELLOW+"▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃"+RESET);

				System.out.println();
				System.out.println("‘’’’’ꕤ’’’’’’’’’’’’’’ꕤ’’’’’’’’’ꕤ‘’’’’ꕤ’’’’’’’’’’’’’’ꕤ’’’’’’’’’ꕤ‘’’’’");
				System.out.println();
				System.out.println("                     ･ ﾟ ₊ ﾟ+ ♡ ♡ ᕬ ᕬ ♡ ♡ ･₊ + .");
				System.out.println("                       + ･ﾟ + ♡ (⌯′-′⌯) ♡ + ･₊ ﾟ ");
				System.out.println("                     ┏━ ʚෆɞ ━━━━ U U━━━ ʚෆɞ ━━┓");
				System.out.println("                     ♡    Cafe KOSTArica    ♡ ");
				System.out.println("                     ┗━ ʚෆɞ ━━━━━━━━━━━ ʚෆɞ ━━┛                   ");
				System.out.println("                         [ 9:00 ~ 21:00 ]");
				System.out.println();
				System.out.println(tCREAM+"        ⠀⠀⠀⠀⠀⠀⠀⠀⠀              ⡀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                       ");
				System.out.println("                   ⠀⠀⠀ ⠀⠀  ⠀⠀⢜⢕⡝⣜⢭⢫⠒⡠⣴⣲⢯⡿⣽⠻⢓⣀⡀⠀⠀⠀                              ");
				System.out.println("                   ⠀⠀⠀⠀ ⠀  ⢀⢵⠈⢕⢵⡱⠕⣁⣮⣟⣗⣯⢿⠝⢁⣼⢯⡯⡿⡄⠀⠀                             ");
				System.out.println("                   ⠀⠀⠀⠀⠀   ⢘⡜⣕⢄⡈⠊⣸⣞⣗⣟⡾⣽⠋⣠⢿⣺⢯⢿⡽⡇⠀⠀⠀                            ");
				System.out.println("              ⠀⠀⠀⠀     ⠀   ⠐⡕⣇⢗⠕⣰⣟⣞⡷⡯⡿⡍⣠⢿⡽⣽⢯⢿⢽⠁⠀⠀⠀                            ");
				System.out.println("              ⠀     ⠀⠀⠀⠀   ⠀⠑⡕⡧⠡⣷⣻⢾⢽⡯⠏⢠⢾⢯⢿⣝⣯⢿⠁⠀⠀⠀⠀⠀                            ");
				System.out.println("           ⠀        ⠀⠀⠀⠀ ⠀⠀  ⠈⠪⠨⡾⣞⣯⠿⠉⣔⣟⣯⢿⡽⡾⠝⠀⠀⠀⠀⠀⠀⠀⠀                           ");
				System.out.println("           ⠀⠀⠀        ⠀⠀ ⠀⠀⠀⠀  ⠀⠈⠉⡨⡴⣯⢯⡷⡻⠝⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                            "+RESET);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("˖♡ ⁺  ᘏ ⑅  ᘏ		         now : Espresso       (Sabrina Ca...)");
				System.out.println("˖° ⁺ ( っ• · •)╮=͟͟͞♡		 ───────────────⚪───────────────────    ");
				System.out.println(". ⠀. ⠀ ⑅ ⠀˚                        ◄◄⠀▐▐⠀►► 𝟸:𝟷𝟾  | 𝟹:𝟻𝟼 ⠀───○    🔊 ");
				System.out.println();
				System.out.println("‘’’’’ꕤ’’’’’’’’’’’’’’ꕤ’’’’’’’’’ꕤ‘’’’’ꕤ’’’’’’’’’’’’’’ꕤ’’’’’’’’’ꕤ‘’’’’");
				
				
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
				break;
		    default:
		    	System.out.println();
		        System.out.println(tRED + "▶ 올바른 숫자를 입력하세요! (1, 2, 0 중 선택)" + RESET);
		        System.out.println();
		        break;
			}//end switch
			
		}//end while
	}//mainMenu
	
	
	/**
	 * 메인화면 메뉴를 출력하는 메소드
	 */
	public static void printMainMenu() {
System.out.println(BOLD+"╔════════════════════════════════════════════════════════════════════╗");
     System.out.println(" 		    KOSTArica Cafe 입니다. 입장하시겠습니까?               ");
     System.out.println("╚════════════════════════════════════════════════════════════════════╝");
System.out.println(bWHITE + tBLACK + 
		                "   1. 카페 이용하기    |   2. 관리자 모드     |   0. 종료		"+RESET);
	}//printMainMenu
	/**
	 * 신메뉴 출력
	 */
	public static void printNewMenuList(List<String> list) {
		for(String menu : list) {
			System.out.print(BOLD+bYELLOW+"NEW!"+RESET +"  "+ menu + "    ");
		}//end for
		
		System.out.println();
	}
	
	/**
	 * 베스트 메뉴 출력
	 */
	public static void printBestMenuList(List<String> list) {
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(tCREAM+"	            	           " +UNDERLINE+ (i+1) + "위." + list.get(i)+RESET + "    ");
			System.out.println();
		}
		
		System.out.println(RESET);
	}
	
	
	
}//class
