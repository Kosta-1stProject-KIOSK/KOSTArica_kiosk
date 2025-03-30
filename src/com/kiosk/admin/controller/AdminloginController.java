package com.kiosk.admin.controller;

import com.kiosk.admin.service.AdminLoginService;
import com.kiosk.admin.view.AdminFailView;

public class AdminloginController {
	static AdminLoginService als = new AdminLoginService();
	
	public static void login(String adminId, String adminPw) {
		try {
			als.login(adminId, adminPw); //로그인 서비스 호출
		} catch (Exception e) {
			AdminFailView.errorMessage(e.getMessage()); //실패 메시지 출력
		}//end catch
		
	}//login
}//class
