package com.kiosk.util;

import java.util.Scanner;

public class InputValid {
	 private static Scanner scanner = new Scanner(System.in);

	    //문자 입력 검증
	    public static String getStringInput(String message) {
	        while (true) {
	            System.out.print(message);
	            String input = scanner.nextLine().trim();
	            if (!input.isEmpty() && input.matches("[a-zA-Z가-힣]+")) {
	                return input;
	            }
	            System.out.println("잘못된 입력입니다. 문자로 입력하세요.");
	        }
	    }

	    //숫자 입력 검증
	    public static int getNumberInput(String message) {
	        while (true) {
	            System.out.print(message);
	            String input = scanner.nextLine().trim();
	            if (input.matches("\\d+")) {
	                return Integer.parseInt(input);
	            }
	            System.out.println("잘못된 입력입니다. 숫자로 입력하세요.");
	        }
	    }

	    //설명 길이 검증
	    public static String getShortDescription(String message) {
	        while (true) {
	            System.out.print(message);
	            String input = scanner.nextLine().trim();
	            if (input.length() <= 33) {
	                return input;
	            }
	            System.out.println("설명은 30자 이내로 입력하세요.");
	        }
	    }
	    
	    //Y 또는 N만 입력받는 유효성 검증
	    public static String getYesOrNoInput(String message) {
	        while (true) {
	            System.out.print(message);
	            String input = scanner.nextLine().trim().toUpperCase();
	            if (input.equals("Y") || input.equals("N")) {
	                return input;
	            }
	            System.out.println("잘못된 입력입니다. Y 또는 N만 입력하세요.");
	        }
	    }

}