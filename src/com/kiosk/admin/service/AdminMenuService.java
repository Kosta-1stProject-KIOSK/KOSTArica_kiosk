package com.kiosk.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.kiosk.admin.model.dao.MenuDAO;
import com.kiosk.admin.model.dao.MenuDAOImpl;
import com.kiosk.admin.model.dto.Menu;
import com.kiosk.exception.NotFoundException;

public class AdminMenuService {
	MenuDAO menuDao = new MenuDAOImpl();
	
    /**
     * 전체 메뉴 조회
     * */
	public List<Menu> searchAll() throws NotFoundException , SQLException{
		List<Menu> list=menuDao.searchAll();
		if(list.size()==0)
			throw new NotFoundException("현재 메뉴가 없습니다.");
		return list;
	}//searchAll
	
}//class
