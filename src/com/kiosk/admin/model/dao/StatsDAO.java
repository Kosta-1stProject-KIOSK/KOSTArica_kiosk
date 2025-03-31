package com.kiosk.admin.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.kiosk.admin.model.dto.Stats;
import com.kiosk.member.model.dto.Order;

public interface StatsDAO {

	/**
	 * 제품 판매수 통계 조회 (일간)
	 */
	List<Stats> menuSalesDaily() throws SQLException;
	
	/**
	 * 제품 판매수 통계 조회 (주간)
	 */
	List<Stats> menuSalesWeekly() throws SQLException;
	
	/**
	 * 제품 판매수 통계 조회 (월간)
	 */
	List<Stats> menuSalesMonthly() throws SQLException;
	
	
	
	/**
	 * 시간별 주문수 통계 조회 (일간)
	 */
	List<Stats> salesTimeDaily() throws SQLException;
	
	/**
	 * 시간별 주문수 통계 조회 (주간)
	 */
	List<Stats> salesTimeWeekly() throws SQLException;
	
	
	
	/**
	 * 지난 매출 비교 통계 조회 (주간)
	 */
	Stats salesCompareWeekly() throws SQLException;
	
	/**
	 * 지난 매출 비교 통계 조회 (월간)
	 */
	Stats salesCompareMonthly() throws SQLException;
	
	
	/**
     * 가장 많이 판매된 상위 N개의 메뉴 조회
     * @param limit (상위 개수 제한)
     * @return 인기 메뉴 리스트
     */
    List<Stats> getTopMenus(int limit);

    
    
    /**
     * 전체 총 매출 금액 반환
     * @return 총 매출 금액
     */
    Stats getTotalSales() throws SQLException;

    
    
    /**
     * 전체 주문 수를 반환합니다.
     * @return 총 주문 수
     */
    int getTotalOrders();
	
}
