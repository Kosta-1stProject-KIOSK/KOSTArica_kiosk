package com.kiosk.admin.controller;

import java.util.List;

import com.kiosk.admin.model.dto.Coupon;
import com.kiosk.admin.service.AdminCouponService;
import com.kiosk.admin.view.AdminCouponView;
import com.kiosk.admin.view.AdminFailView;
import com.kiosk.admin.view.AdminMenuView;

public class AdminCouponController {
	static AdminCouponService acs = new AdminCouponService();
	
	/**
	 * 전체 쿠폰 조회
	 */
	public static void searchAll() {
		try {
			List<Coupon> coupon = acs.searchAll();
			AdminCouponView.printAllCouponList(coupon, false);
		} catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		} finally {
			System.out.println("관리자 쿠폰 관리 화면으로 돌아갑니다.");
			AdminCouponView.printAdminCouponManage();
		}//end finally
	}//searchAll
	
	/**
	 * 회원별 쿠폰 조회
	 */
	public static void searchByMember(String memberId) {
		try {
			List<Coupon> coupon = acs.searchByMember(memberId);
			AdminCouponView.printAllCouponList(coupon, true);
		} catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		} finally {
			System.out.println("관리자 쿠폰 관리 화면으로 돌아갑니다.");
			AdminCouponView.printAdminCouponManage();
		}//end finally
	}//searchByMember
	
	
	/**
	 * 쿠폰 등록
	 */
	public static void insertCoupon(Coupon coupon) {
		try {
			int result = acs.insertCoupon(coupon);
			AdminCouponView.printMessage(result + "건 등록되었습니다!");
		}catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		} finally {
			System.out.println("관리자 쿠폰 관리 화면으로 돌아갑니다.");
			AdminCouponView.printAdminCouponManage();
		}//end finally
	}//insertMenu
	
	/**
	 * 쿠폰 사용여부 조회
	 */
	public static String searchByCouponNo(int couponNo) {
		try {
			int result = acs.searchByCouponNo(couponNo);
			
			//쿠폰이 존재하지 않으면
			if(result == -1) {
				return null; //해당 쿠폰이 존재하지 않음을 return
			}
			
			//쿠폰이 존재하는 경우
			String couponStatus = (result == 0) ? "사용가능" : "사용완료";
			return couponStatus; //현재 상태를 return
			
		}catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
			return null;
		}
	}//updateMenu
	
	/**
	 * 쿠폰 사용여부 갱신
	 */
	public static void updateCoupon(int couponNo) {
		try {
			int result = acs.updateCoupon(couponNo);
			AdminCouponView.printMessage(result + "건 수정되었습니다!");
		}catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		} finally {
			System.out.println("관리자 쿠폰 관리 화면으로 돌아갑니다.");
			AdminCouponView.printAdminCouponManage();
		}//end finally
	}//updateMenu
	
	/**
	 * 쿠폰 삭제
	 */
	public static void deleteCoupon(int couoponNo) {
		try {
			int result = acs.deleteCoupon(couoponNo);
			AdminCouponView.printMessage(result + "건 삭제되었습니다!");
		}catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		} finally {
			System.out.println("관리자 쿠폰 관리 화면으로 돌아갑니다.");
			AdminCouponView.printAdminCouponManage();
		}//end finally
	}//deleteCoupon
	
}//class
