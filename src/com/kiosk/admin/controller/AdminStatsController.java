package com.kiosk.admin.controller;

import java.util.List;

import com.kiosk.admin.model.dto.Stats;
import com.kiosk.admin.service.AdminStatsService;
import com.kiosk.admin.view.AdminFailView;
import com.kiosk.admin.view.AdminStatsView;
import com.kiosk.view.ConsoleColor;

public class AdminStatsController implements ConsoleColor{
	static AdminStatsService ass = new AdminStatsService();
	
	/**
	 * 메뉴 판매수 통계 조회
	 */
	public static void MenuSales(int period) {
		try {
			List<Stats> list = ass.MenuSales(period);
			AdminStatsView.printMenuSalesList(list, period);
		} catch (Exception e) {
			AdminFailView.errorMessage(tRED + "▶ 현재 통계를 낼 수 없습니다." + RESET);
		} finally {
			System.out.println();
			System.out.println("▶ 관리자 메뉴 통계 화면으로 돌아갑니다.");
			AdminStatsView.printAdminStatsManage();
		}//end finally
	}//MenuSales
	
	/**
	 * 전체 총 매출
	 */
	public static void getTotalSales() {
		try {
			Stats stats = ass.getTotalSales();
			AdminStatsView.printTotalSales(stats);
		} catch (Exception e) {
			AdminFailView.errorMessage(tRED + "▶ 현재 통계를 낼 수 없습니다." + RESET);
		} finally {
			System.out.println();
			System.out.println("▶ 관리자 메뉴 통계 화면으로 돌아갑니다.");
			AdminStatsView.printAdminStatsManage();
		}
	}
	
	/**
	 * 시간대별 주문수 통계 조회
	 */
	public static void SalesTime(int period) {
		try {
			List<Stats> list = ass.salesTime(period);
			AdminStatsView.printSalesTimeList(list, period);
		} catch (Exception e) {
			AdminFailView.errorMessage(tRED + "▶ 현재 통계를 낼 수 없습니다." + RESET);
		} finally {
			System.out.println();
			System.out.println("▶ 관리자 메뉴 통계 화면으로 돌아갑니다.");
			AdminStatsView.printAdminStatsManage();
		}//end finally
	}//MenuSales
	
	/**
	 * 지난 매출 비교 통계 조회
	 */
	public static void salesCompare(int period) {
		try {
			Stats stats = ass.salesCompare(period);
			AdminStatsView.printSalesCompare(stats, period);
		} catch (Exception e) {
			AdminFailView.errorMessage(tRED + "▶ 현재 통계를 낼 수 없습니다." + RESET);
		} finally {
			System.out.println();
			System.out.println("▶ 관리자 메뉴 통계 화면으로 돌아갑니다.");
			AdminStatsView.printAdminStatsManage();
		}//end finally
	}//MenuSales
}
