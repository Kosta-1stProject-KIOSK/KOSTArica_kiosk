package com.kiosk.admin.controller;

import java.util.List;

import com.kiosk.admin.model.dto.Menu;
import com.kiosk.admin.service.AdminMenuService;
import com.kiosk.admin.view.AdminFailView;
import com.kiosk.admin.view.AdminMenuView;

public class AdminMenuController {
	static AdminMenuService ams = new AdminMenuService();
	
	/**
	 * 전체 메뉴 조회
	 */
	public static void searchAll() {
		try {
			List<Menu> menu = ams.searchAll();
			AdminMenuView.printAllMenuList(menu);
		} catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		}//end catch
	}//searchAll
	
	
}//class
