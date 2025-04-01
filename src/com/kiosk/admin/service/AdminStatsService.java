package com.kiosk.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.kiosk.admin.model.dao.StatsDAO;
import com.kiosk.admin.model.dao.StatsDAOImpl;
import com.kiosk.admin.model.dto.Stats;
import com.kiosk.exception.NotFoundException;
import com.kiosk.view.ConsoleColor;

public class AdminStatsService implements ConsoleColor{
	StatsDAO statsDao = new StatsDAOImpl();
	
    /**
     * 메뉴 판매수 통계 조회
     * */
	public List<Stats> MenuSales(int period) throws NotFoundException , SQLException {
		List<Stats> list = null;
		
		switch(period) {
		case 1: //일간
			list = statsDao.menuSalesDaily();
			break;
		case 2: //주간
			list = statsDao.menuSalesWeekly();
			break;
		case 3: //월간
			list = statsDao.menuSalesMonthly();
			break;
		}
		
		if(list.size()==0)
			throw new NotFoundException(tRED + "▶ 현재 통계를 낼 수 없습니다." + RESET);
		
		return list;
	}//MenuSales
	
	/**
	 * 전체 총 매출
	 */
	public Stats getTotalSales() throws NotFoundException, SQLException {
		Stats stats = statsDao.getTotalSales();
		
		if(stats == null)
			throw new NotFoundException(tRED + "▶ 현재 통계를 낼 수 없습니다." + RESET);
		
		return stats;
	}
	
    /**
     * 시간대별 주문수 통계 조회
     * */
	public List<Stats> salesTime(int period) throws NotFoundException , SQLException {
		List<Stats> list = null;
		
		switch(period) {
		case 1: //일간
			list = statsDao.salesTimeDaily();
			break;
		case 2: //주간
			list = statsDao.salesTimeWeekly();
			break;
		}
		
		if(list.size()==0)
			throw new NotFoundException(tRED + "▶ 현재 통계를 낼 수 없습니다." + RESET);
		
		return list;
	}//SalesTime
	
	/**
     * 지난 매출 비교 통계 조회
     * */
	public Stats salesCompare(int period) throws NotFoundException , SQLException {
		Stats stats = null;
		
		switch(period) {
		case 1: //주간
			stats = statsDao.salesCompareWeekly();
			break;
		case 2: //월간
			stats = statsDao.salesCompareMonthly();
			break;
		}
		
		if(stats == null)
			throw new NotFoundException(tRED + "▶ 현재 판매된 메뉴가 없습니다." + RESET);
		
		return stats;
	}//salesCompare

}//class
