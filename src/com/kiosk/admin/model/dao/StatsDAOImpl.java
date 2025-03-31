package com.kiosk.admin.model.dao;

import java.util.List;

import com.kiosk.admin.model.dto.Stats;

public class StatsDAOImpl implements StatsDAO {
	
	/**
	 * 기간에 따른 매출 통계 조회
	 * @param periodType (기간 일간, 주간, 월간)
	 * @return 매출 통계 List
	 */
	@Override
	public List<Stats> getSalesByMenu(String periodType) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 가장 많이 판매된 상위 N개의 메뉴 조회
     * @param limit (상위 개수 제한)
     * @return 인기 메뉴 리스트
     */
	@Override
	public List<Stats> getTopMenus(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 전체 총 매출 금액 반환
     * @return 총 매출 금액
     */
	@Override
	public int getTotalSales() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	/**
     * 전체 주문 수를 반환합니다.
     * @return 총 주문 수
     */
	@Override
	public int getTotalOrders() {
		// TODO Auto-generated method stub
		return 0;
	}

}
