package com.kiosk.admin.dao;

import java.util.List;

import com.kiosk.admin.model.dto.MenuDTO;

public class MenuDAOImpl implements MenuDAO {

	
	/**
	 * 메뉴번호로 메뉴 정보 조회
	 * @param menuNo
	 * @return MenuDTO (메뉴 정보가 담긴 객체)
	 */
	@Override
	public MenuDTO searchById(int menuNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 카테고리 번호로 해당 카테고리의 메뉴를 조회
     * @param categoryNo 카테고리 번호
     * @return 해당 카테고리의 메뉴 리스트(List)
     */
	@Override
	public List<MenuDTO> searchByCategory(int categoryNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 전체 메뉴 목록 조회
     * @return 메뉴 리스트(List)
     */
	@Override
	public List<MenuDTO> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 메뉴 등록
     * @param 등록할 메뉴 정보(MenuDTO menu)
     */
	@Override
	public void insert(MenuDTO menu) {
		// TODO Auto-generated method stub
		
	}

	
	
	/**
     * 메뉴 정보 수정
     * @param 수정할 메뉴 정보 객체(MenuDTO menu)
     */
	@Override
	public void update(MenuDTO menu) {
		// TODO Auto-generated method stub
		
	}

	
	
	/**
     * 메뉴 삭제
     * @param menuNo 삭제할 메뉴 번호
     */
	@Override
	public void delete(int menuNo) {
		// TODO Auto-generated method stub
		
	}

}
