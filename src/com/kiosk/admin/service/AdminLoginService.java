package com.kiosk.admin.service;

import com.kiosk.admin.view.AdminMainView;
import com.kiosk.exception.NotFoundException;

public class AdminLoginService {
	public void login(String adminId, String adminPw) throws NotFoundException {
		if(adminId.equals("kosta295") && adminPw.equals("1234")) {
			AdminMainView.adminMainMenu();
		} else {
			throw new NotFoundException("틀린 비밀번호이거나 아이디가 존재하지 않습니다.");
		}//end if
		
	}//login
	
}//class
