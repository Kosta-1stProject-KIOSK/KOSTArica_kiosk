package com.kiosk.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.kiosk.admin.model.dao.StatsDAO;
import com.kiosk.admin.model.dao.StatsDAOImpl;
import com.kiosk.admin.model.dto.Stats;
import com.kiosk.exception.NotFoundException;

public class AdminStatsService {
	StatsDAO statsDao = new StatsDAOImpl();
	
    /**
     * 제품 판매수 통계 조회 (일간)
     * */
	public List<Stats> MenuSales(int period) throws NotFoundException , SQLException {
		List<Stats> list = null;
		
		switch(period) {
		case 1: //일간
			list = statsDao.MenuSalesDaily();
			break;
		case 2: //주간
			list = statsDao.MenuSalesWeekly();
			break;
		case 3: //월간
			list = statsDao.MenuSalesMonthly();
			break;
		}
		
		if(list.size()==0)
			throw new NotFoundException("현재 판매된 메뉴가 없습니다.");
		
		return list;
	}//searchAll

}//class
