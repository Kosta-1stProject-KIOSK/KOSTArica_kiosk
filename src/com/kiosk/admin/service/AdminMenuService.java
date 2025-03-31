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
	
	/**
	 * 메뉴 등록
	 */
	public int insertMenu(Menu menu) throws SQLException{
		int result =  menuDao.insert(menu);
		if(result == 0) {
			throw new SQLException("메뉴 등록이 실패하였습니다.");
		} else {
			return 1;
		}//end else
	}//insertMenu
	
	/**
	 * 메뉴 수정
	 */
	public int updateMenu(Menu menu) throws SQLException{
		int result =  menuDao.update(menu);
		if(result == 0) {
			throw new SQLException("메뉴 수정이 실패하였습니다.");
		} else {
			return 1;
		}//end else
	}//updateMenu
	
	/**
	 * 메뉴 삭제
	 */
	public int deleteMenu(int menuNo) throws SQLException{
		int result =  menuDao.delete(menuNo);
		if(result == 0) {
			throw new SQLException("메뉴 삭제가 실패하였습니다.");
		} else {
			return 1;
		}//end else
	}//deleteMenu
	
}//class
