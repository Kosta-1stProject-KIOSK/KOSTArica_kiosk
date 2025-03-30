package com.kiosk.exception;

/**
 * 관리자 로그인 실패시 예외
 */
public class AdminLoginException extends Exception {
	
	public AdminLoginException(String message) {
		super(message);
	}//생성자
	
}//AdminLoginException
