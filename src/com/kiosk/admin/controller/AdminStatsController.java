//package com.kiosk.admin.controller;
//
//import java.util.List;
//
//import com.kiosk.admin.model.dto.Stats;
//import com.kiosk.admin.service.AdminStatsService;
//import com.kiosk.admin.view.AdminFailView;
//
//public class AdminStatsController {
//	static AdminStatsService ass = new AdminStatsService();
//	
//	/**
//	 * 전체 메뉴 조회
//	 */
//	public static void MenuSales(int period) {
//		try {
//			List<Stats> menu = ass.MenuSales(period);
//			AdminStatsView.printMenuSalesList(period);
//		} catch (Exception e) {
//			AdminFailView.errorMessage(e.getMessage());
//		} finally {
//			System.out.println("관리자 메뉴 통계 화면으로 돌아갑니다.");
//			AdminStatsView.printStatsMenuManage();
//		}//end finally
//	}//searchAll
//}
