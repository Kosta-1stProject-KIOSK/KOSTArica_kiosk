package com.kiosk.admin.controller;

import java.util.List;

import com.kiosk.admin.model.dto.Menu;
import com.kiosk.admin.service.AdminMenuService;
import com.kiosk.admin.view.AdminFailView;
import com.kiosk.admin.view.AdminMainView;
import com.kiosk.admin.view.AdminMenuView;
import com.kiosk.view.MainMenuView;

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
		} finally {
			System.out.println("관리자 메뉴 관리 화면으로 돌아갑니다.");
			AdminMenuView.printAdminMenuManage();
		}//end finally
	}//searchAll
	
	/**
	 * 메뉴 등록
	 */
	public static void insertMenu(Menu menu) {
		try {
			int result = ams.insertMenu(menu);
			AdminMenuView.printMessage(result + "건 등록되었습니다!");
		}catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		} finally {
			System.out.println("관리자 메뉴 관리 화면으로 돌아갑니다.");
			AdminMenuView.printAdminMenuManage();
		}//end finally
	}//insertMenu
	
	/**
	 * 메뉴 수정
	 */
	public static void updateMenu(Menu menu) {
		try {
			int result = ams.updateMenu(menu);
			AdminMenuView.printMessage(result + "건 수정되었습니다!");
		}catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		} finally {
			System.out.println("관리자 메뉴 관리 화면으로 돌아갑니다.");
			AdminMenuView.printAdminMenuManage();
		}//end finally
	}//updateMenu
	
	/**
	 * 메뉴 삭제
	 */
	public static void deleteMenu(int menuNo) {
		try {
			int result = ams.deleteMenu(menuNo);
			AdminMenuView.printMessage(result + "건 삭제되었습니다!");
		}catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		} finally {
			System.out.println("관리자 메뉴 관리 화면으로 돌아갑니다.");
			AdminMenuView.printAdminMenuManage();
		}//end finally
	}//deleteMenu
	
	
	///////////////////////////전체 메인 화면 용///////////////////////////
	
	
	/**
	 * 신메뉴 조회
	 */
	public static void searchNewMenu() {
		try {
			List<String> menu = ams.searchNewMenu();
			MainMenuView.printNewMenuList(menu);
		} catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		}//end catch
	}//searchNewMenu
	
	/**
	 * 베스트 메뉴 조회
	 */
	public static void searchBestMenu() {
		try {
			List<String> menu = ams.searchBestMenu();
			MainMenuView.printBestMenuList(menu);
		} catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage());
		}//end catch
	}//searchNewMenu
	
}//class
