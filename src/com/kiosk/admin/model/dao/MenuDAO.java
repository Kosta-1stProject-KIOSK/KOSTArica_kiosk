package com.kiosk.admin.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.kiosk.admin.model.dto.Menu;

public interface MenuDAO {

	/**
	 * 메뉴번호로 메뉴 정보 조회
	 * @param menuNo
	 * @return MenuDTO (메뉴 정보가 담긴 객체)
	 */
	Menu searchById (int menuNo);	
	
	
	
	/**
     * 카테고리 번호로 해당 카테고리의 메뉴를 조회
     * @param categoryNo 카테고리 번호
     * @return 해당 카테고리의 메뉴 리스트(List)
     */
    List<Menu> searchByCategory(int categoryNo);

    
    
    /**
     * 전체 메뉴 목록 조회
     * @return 메뉴 리스트(List)
     * @throws SQLException 
     */
    List<Menu> searchAll() throws SQLException;

    
    
    /**
     * 메뉴 등록
     * @param 등록할 메뉴 정보(MenuDTO menu)
     */
    int insert(Menu menu) throws SQLException;

    
    
    /**
     * 메뉴 정보 수정
     * @param 수정할 메뉴 정보 객체(MenuDTO menu)
     */
    int update(Menu menu) throws SQLException;

    
    
    /**
     * 메뉴 삭제
     * @param menuNo 삭제할 메뉴 번호
     * @return 
     */
    int delete(int menuNo) throws SQLException;
    
    
}
