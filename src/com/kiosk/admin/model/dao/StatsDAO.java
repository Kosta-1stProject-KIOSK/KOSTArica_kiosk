package com.kiosk.admin.model.dao;

import java.util.List;

import com.kiosk.admin.model.dto.StatsDTO;

public interface StatsDAO {

	/**
	 * 기간에 따른 매출 통계 조회
	 * @param periodType (기간 일간, 주간, 월간)
	 * @return 매출 통계 List
	 */
	List<StatsDTO> getSalesByMenu(String periodType);
	
	
	
	/**
     * 가장 많이 판매된 상위 N개의 메뉴 조회
     * @param limit (상위 개수 제한)
     * @return 인기 메뉴 리스트
     */
    List<StatsDTO> getTopMenus(int limit);

    
    
    /**
     * 전체 총 매출 금액 반환
     * @return 총 매출 금액
     */
    int getTotalSales();

    
    
    /**
     * 전체 주문 수를 반환합니다.
     * @return 총 주문 수
     */
    int getTotalOrders();
	
}
