package com.kiosk.admin.view;

import java.util.List;
import java.util.Scanner;

import com.kiosk.admin.controller.AdminCouponController;
import com.kiosk.admin.model.dto.Coupon;
import com.kiosk.util.InputValid;
import com.kiosk.view.ConsoleColor;

/**
 * 관리자모드 > 메인 화면 > 쿠폰 관리 View
 */
public class AdminCouponView implements ConsoleColor {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 쿠폰 관리 메인 화면 출력
	 */
	public static void printAdminCouponManage() {
		System.out.println();
		System.out.println();
		System.out.println("════════════════════════════════════════════════════════════════════════");
		System.out.println("		쿠폰 관리 페이지입니다. 무엇을 하시겠습니까?");
		System.out.println("════════════════════════════════════════════════════════════════════════");

		while (true) {
			System.out.println(bWHITE+tBLACK+"[1] 전체 조회 | [2]회원별 조회 | [3]발행 | [4]사용갱신 | [5]삭제 | [0]뒤로  "+RESET);
			int input = InputValid.getNumberInput("선택 ▶ ");
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				//전체 조회 화면
				AdminCouponController.searchAll(true);
				break;
			case 2:
				// 회원별 조회 화면
				printSearchByMemberId();
				break;
			case 3:
				// 쿠폰 발행 화면
				printInsertProcess();
				break;
			case 4:
				// 쿠폰 수정 화면
				printUpdateProcess();
				break;
			case 5:
				// 쿠폰 삭제 화면
				printDeleteProcess();
				break;
			case 0:
				AdminMainView.adminMainMenu(); // 뒤로가기 (관리자 메인 메뉴 화면)
			}// end switch

		} //end while
		
	}//printAdminMenuManage
	
	////////////////////////////Process View//////////////////////////
	/**
	 * 쿠폰 회원별 조회 Process View
	 */
	public static void printSearchByMemberId() {
		String memberId = InputValid.getPhoneNumberInput("▶ 회원 전화번호를 입력하세요 (숫자만) : ");
		
		AdminCouponController.searchByMember(memberId);
		
	}//printSearchByMemberId
	
	/**
	 * 쿠폰 발행 Process View
	 */
	public static void printInsertProcess() {
		String couponName = InputValid.getStringInput("▶ 쿠폰명을 입력하세요 : ");
		
		int discount = InputValid.getNumberInput("▶ 할인 금액을 입력하세요 : ");
		
		 // 시작일과 만료일을 각각 유효성 검증
	    String validFrom = InputValid.getValidDateInput("▶ 시작일 입력");
	    String validUntil = InputValid.getValidDateInput("▶ 만료일 입력");
		
		String memberId = InputValid.getPhoneNumberInput("▶ 발급하실 회원의 전화번호를 입력하세요 (숫자만): ");
		
		Coupon coupon = new Coupon(couponName, discount, validFrom, validUntil, memberId);
		AdminCouponController.insertCoupon(coupon);
		sc.nextLine(); // 개행 문자 제거 (다른 입력이 있을 경우 대비)
		
	}//printInsertProcess
	
	/**
	 * 쿠폰 사용여부 갱신 Process View
	 */
	public static void printUpdateProcess() {
		System.out.println("******************* [ 쿠폰 번호를 먼저 확인 하세요. ] *******************");
		// 전체 조회 화면
		AdminCouponController.searchAll(false);
		
		int couponNo = InputValid.getNumberInput("▶ 쿠폰 사용여부를 갱신하려는 쿠폰번호를 입력하세요 : ");
		
		//쿠폰 상태 조회
		String couponIsUsed = AdminCouponController.searchByCouponNo(couponNo);
		
		//쿠폰이 존재하지 않을 때
		if(couponIsUsed == null) {
			System.out.println();
			printMessage(tRED + "▶ 해당 쿠폰은 존재하지 않습니다." + RESET);
			System.out.println();
			printMessage("▶ 관리자 쿠폰 관리 화면으로 돌아갑니다.");
			printAdminCouponManage();
			return;
		}
		
		//쿠폰이 존재할 때
		printMessage(tCYAN + "현재 쿠폰 사용여부는 [" + couponIsUsed + "] 입니다." + RESET);
		
		//상태변경 여부 변경
		String input = InputValid.getYesOrNoInput("▶ 쿠폰 상태를 변경하시겠습니까? (Y/N) : ").toUpperCase();
		
		if(input.equals("Y")) {
			AdminCouponController.updateCoupon(couponNo);
		} else {
			System.out.println();
			printMessage("▶ 쿠폰 상태 변경을 취소하였습니다.");
			System.out.println();
			printMessage("▶ 관리자 쿠폰 관리 화면으로 돌아갑니다.");
			printAdminCouponManage();
		}//end if
		
	}//printUpdateProcess
	
	/**
	 * 메뉴 삭제 Process View
	 */
	public static void printDeleteProcess() {
		System.out.println("******************* [ 쿠폰 번호를 먼저 확인 하세요. ] *******************");
		// 전체 조회 화면
		AdminCouponController.searchAll(false);
		int couponNo = InputValid.getNumberInput("▶ 삭제하려는 쿠폰 번호를 입력하세요 : ");
		
		AdminCouponController.deleteCoupon(couponNo);
		
	}//printDeleteProcess
	
	////////////////////////////End View//////////////////////////
	
	
	/**
	 * 조회 시 쿠폰 리스트 출력 - 전체, 회원별
	 */
	public static void printAllCouponList(List<Coupon> list, boolean isMemberView) {
		System.out.println("***************************** [ 전체 " + list.size() + "개 ] *******************************");
//		for(Coupon coupon : list) {
//			if(isMemberView) { //회원별 조회일 경우
//				System.out.println("");
//				System.out.println(coupon.toStringForSearchByMember());
//			} else {
//				System.out.println("");
//				System.out.println(coupon); //전체 조회일 경우
//			}//end else
//		}//end for
		
		if(isMemberView) { //회원별 조회일 경우
			System.out.println(bWHITE+tBLACK+"   쿠폰번호  |  쿠폰이름  |  할인금액  |  시작일  |  만료일  |  사용여부     "+RESET);
		for(Coupon coupon : list) {
				System.out.println(coupon.toStringForSearchByMember());
			}//end else
		}else {
			System.out.println(bWHITE+tBLACK+"   쿠폰번호 | 쿠폰이름 | 할인금액 | 시작일 | 만료일 | 사용여부 | 회원번호    "+RESET);
			for(Coupon coupon : list) {
			System.out.println(coupon); //전체 조회일 경우
			}
		}
		System.out.println();
	}
	
	/**
	 * 단순 출력 메소드
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}

}//class
