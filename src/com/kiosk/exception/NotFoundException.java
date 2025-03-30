package com.kiosk.exception;

/**
 * 검색했을 때 찾고자 하는 정보가 없는 경우 예외
 */
public class NotFoundException extends Exception {
	
	public NotFoundException(String message) {
		super(message);
	}
	
}

