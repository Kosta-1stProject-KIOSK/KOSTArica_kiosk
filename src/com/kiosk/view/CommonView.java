//package com.kiosk.view;
//
//import java.util.Calendar;
//
///**
// *  시작 화면 출력 클래스
// */
//public class CommonView implements ConsoleColor {
//
//	
//	//현재시간
//	public static Calendar now = Calendar.getInstance();
//	
//	//프로그램 시작 > 판매, 관리, 종료 선택
//	public static void printModeSelct() {
//
//			
//			System.out.println();
//			System.out.println();
//		    System.out.println();
//			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t"+RESET+BOLD+UNDERLINE+"CAFE Kostarica"+RESET+bWHITE+"\t\t\t\t\t\t"+RESET+"┃");                                
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t"+RESET+"[ 운영 시간 : 07:00 ~20:00 ]"+bWHITE+"\t\t"+RESET+"┃");                                
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.printf( "┃"+bWHITE+tBLACK+"\t\t\t\t\t\t\t%2tY년  %2tm월  %2td일  %2tH시  %2tM분\t"+RESET+"┃\r\n",now,now,now,now,now);
//			System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+tBLACK+"\t\t\tCafe KOSTArica에 오신 것을 환영합니다.\t\t\t\t"+RESET+"┃");
//			System.out.println("┃"+bWHITE+tBLACK+"\t\t\t이용할 서비스를 선택해주세요.\t\t\t\t\t"+RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t"+RESET+bBULE+"┌───────────────────┐"+RESET+bWHITE+"  \t"+RESET+bBULE+"┌───────────────────┐"+RESET+bWHITE+"  \t\t\t" +RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t"+RESET+bBULE+"│\t\t    │"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t    │"+RESET+bWHITE+"\t\t\t\t" +RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t"+RESET+bBULE+"│ (1)카페 이용\t    │"+RESET+bWHITE+"  \t"+RESET+bBULE+"│ (2)관리자 모드    │"+RESET+bWHITE+"\t\t\t\t" +RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t"+RESET+bBULE+"│\t\t    │"+RESET+bWHITE+"  \t"+RESET+bBULE+"│\t\t    │"+RESET+bWHITE+"\t\t\t\t" +RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t"+RESET+bBULE+"└───────────────────┘"+RESET+bWHITE+"\t\t"+RESET+bBULE+"└───────────────────┘"+RESET+bWHITE+"  \t\t\t" +RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//1
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//2
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//3
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//4
//			System.out.println("┃"+bWHITE+tBLACK+"\t\t\t\t\t\t\t\t\t\t\t"+RESET+"┃");//5
//			System.out.println("┃"+bWHITE+tBLACK+"\t종료 : 0"+"\t\t\t\t\t\t\t\t\t"+RESET+"┃");//6
//			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"+RESET);
//			System.out.print("    "+bYELLOW+tBLACK+UNDERLINE+"선택"+RESET+" : ");
//
//		}
//
//		//회원 로그인 실패시
//
//		public static void printLoginFailed() {
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t"+RESET+BOLD+UNDERLINE+"CAFE Kostarica"+RESET+bWHITE+"\t\t\t\t\t\t"+RESET+"┃");                            
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t"+RESET+"[ 운영 시간 : 07:00 ~21:00 ]"+bWHITE+"\t\t"+RESET+"┃");                             
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.printf( "┃"+bWHITE+tBLACK+"\t\t\t\t\t\t\t%2tY년  %2tm월  %2td일  %2tH시  %2tM분\t"+RESET+"┃\r\n",now,now,now,now,now);
//			System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+tBLACK+"\t\t※아이디 또는 비밀번호가 잘못되었습니다.\t\t\t\t\t"+RESET+"┃");//2
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
////			System.out.println("┃"+bWHITE+tBLACK+"\t\tID\t:\t회원명\t\t\t\t\t\t\t"+RESET+"┃");//5
////			System.out.println("┃"+bWHITE+tBLACK+"\t\tPW\t:\t ●  +  일련번호(8자리)\t\t\t\t\t"+RESET+"┃");//6
////			System.out.println("┃"+bWHITE+tBLACK+"\t\t(● : 회원은 m,강사는 i,관리자는 a를 입력해주세요.)\t\t\t"+RESET+"┃");//8
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//7
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//9
//			System.out.println("┃"+bWHITE+tBLACK+"\t\t※재시도 하시겠습니까? ( Y / N )\t\t\t\t\t\t"+RESET+"┃");//3
//			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
//			System.out.print("    "+bYELLOW+tBLACK+UNDERLINE+"선택"+RESET+" : ");
//			System.out.println();
//			
//		}
//
//	
//	
//		// 회원 로그인 베너 출력
//		public static void printAdminLogin() {
//
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t"+RESET+BOLD+UNDERLINE+"CAFE Kostarica"+RESET+bWHITE+"\t\t\t\t\t\t"+RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t"+RESET+"[ 운영 시간 : 07:00 ~ 21:00 ]"+bWHITE+"\t\t"+RESET+"┃");                                
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.printf( "┃"+bWHITE+tBLACK+"\t\t\t\t\t\t\t%2tY년  %2tm월  %2td일  %2tH시  %2tM분\t"+RESET+"┃\r\n",now,now,now,now,now);
//			System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");
//			System.out.println("┃"+bWHITE+tBLACK+"\t\t\t로그인을 위해 아이디와 비밀번호를 입력해주세요.\t\t\t"+RESET+"┃");
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
//			System.out.println("┃"+bWHITE+"\t\t\t\t\t\t\t\t\t\t\t"+ RESET+"┃");//
//			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"+RESET);
////			System.out.print("    "+bYELLOW+tBLACK+UNDERLINE+"ID"+RESET+" : ");
////			System.out.print("    "+bYELLOW+tBLACK+UNDERLINE+"PW"+RESET+" : ");
//		}
//
//
//
//}
