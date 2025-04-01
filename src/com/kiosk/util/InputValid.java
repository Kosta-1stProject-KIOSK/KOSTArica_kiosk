package com.kiosk.util;

import java.util.Scanner;

import com.kiosk.view.ConsoleColor;

public class InputValid implements ConsoleColor{
    private static Scanner scanner = new Scanner(System.in);

    // 문자 입력 검증
    public static String getStringInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(tRED + "▶ 입력값이 공백입니다. 다시 입력하세요." + RESET);
                continue;
            }
            if (input.matches("[a-zA-Z가-힣]+")) {
                return input;
            }
            System.out.println(tRED + "▶ 잘못된 입력입니다. 문자로 입력하세요." + RESET);
        }
    }

    // 숫자 입력 검증
    public static int getNumberInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(tRED + "▶ 입력값이 공백입니다. 숫자로 다시 입력하세요." + RESET);
                continue;
            }
            if (input.matches("\\d+")) {
                return Integer.parseInt(input);
            }
            System.out.println(tRED + "▶ 잘못된 입력입니다. 숫자로 입력하세요." + RESET);
        }
    }

    // 설명 길이 검증
    public static String getShortDescription(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(tRED + "▶ 입력값이 공백입니다. 다시 입력하세요." + RESET);
                continue;
            }
            if (input.length() <= 33) {
                return input;
            }
            System.out.println(tRED + "▶ 설명은 30자 이내로 입력하세요." + RESET);
        }
    }

    // Y 또는 N만 입력받는 유효성 검증
    public static String getYesOrNoInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.isEmpty()) {
                System.out.println(tRED + "▶ 입력값이 공백입니다. Y 또는 N만 입력하세요." + RESET);
                continue;
            }
            if (input.equals("Y") || input.equals("N")) {
                return input;
            }
            System.out.println(tRED + "▶ 잘못된 입력입니다. Y 또는 N만 입력하세요." + RESET);
        }
    }

    // 전화번호 입력 검증 (11자리 숫자만 입력)
    public static String getPhoneNumberInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(tRED + "▶ 입력값이 공백입니다. 전화번호를 다시 입력하세요." + RESET);
                continue;
            }
            // 11자리 숫자만 입력 받기
            if (input.matches("^\\d{11}$")) {
                // 3-4-4 형식으로 변환하여 반환
                return formatPhoneNumber(input);
            }
            System.out.println(tRED + "▶ 잘못된 입력입니다. 11자리 숫자로만 입력하세요." + RESET);
        }
    }

    // 11자리 숫자를 3-4-4 형식으로 변환
    private static String formatPhoneNumber(String phoneNumber) {
        return phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 7) + "-" + phoneNumber.substring(7);
    }

    ///////////////////////////// 날짜 /////////////////////////////
    // 년도 유효성 검증
    public static boolean isValidYear(String year) {
        return year.matches("\\d{4}");
    }

    // 월 유효성 검증 (01부터 12까지)
    public static boolean isValidMonth(String month) {
        return month.matches("\\d{2}") && Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12;
    }

    // 일 유효성 검증 (날짜 체크)
    public static boolean isValidDay(String day, int year, int month) {
        if (!day.matches("\\d{2}") || Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31) {
            return false;
        }
        return isValidDate(year, month, Integer.parseInt(day));
    }

    // 날짜 유효성 검증
    private static boolean isValidDate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }

        int daysInMonth = getDaysInMonth(year, month);
        return day >= 1 && day <= daysInMonth;
    }

    // 월별 날짜 수를 반환하는 메소드
    private static int getDaysInMonth(int year, int month) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        return (month == 4 || month == 6 || month == 9 || month == 11) ? 30 : 31;
    }

    // 윤년 확인
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    // 년, 월, 일 입력 받는 메소드 (유효성 검증 포함)
    public static String getValidDateInput(String dateType) {
        String year, month, day;

        while (true) {
            // 년도 입력
            System.out.print("▶ " + dateType + " 년도(4자리): ");
            year = scanner.nextLine().trim();
            if (year.isEmpty()) {
                System.out.println(tRED + "▶ 년도는 4자리 숫자여야 합니다." + RESET);
                continue;
            }
            if (!isValidYear(year)) {
                System.out.println(tRED + "▶ 년도는 4자리 숫자여야 합니다." + RESET);
                continue;
            }

            // 월 입력
            while (true) {
                System.out.print("▶ " + dateType + " 월: ");
                month = scanner.nextLine().trim();
                if (month.isEmpty()) {
                    System.out.println(tRED + "▶ 월은 01에서 12 사이의 숫자여야 합니다." + RESET);
                    continue;
                }
                if (month.length() == 1) {
                    month = "0" + month;  // 1자리 입력 시 2자리로 변환 (1 -> 01)
                }
                if (!isValidMonth(month)) {
                    System.out.println(tRED + "▶ 월은 01에서 12 사이의 숫자여야 합니다." + RESET);
                    continue;  // 월이 잘못되면 다시 월만 입력 받음
                }
                break; // 월이 유효하면 반복문 종료
            }

            // 일 입력
            while (true) {
                System.out.print("▶ " + dateType + " 일: ");
                day = scanner.nextLine().trim();
                if (day.isEmpty()) {
                    System.out.println(tRED + "▶ 일은 01에서 31 사이의 숫자여야 합니다." + RESET);
                    continue;
                }
                if (day.length() == 1) {
                    day = "0" + day;  // 1자리 입력 시 2자리로 변환 (1 -> 01)
                }
                if (!isValidDay(day, Integer.parseInt(year), Integer.parseInt(month))) {
                    System.out.println(tRED + "▶ 잘못된 날짜입니다. 다시 입력하세요." + RESET);
                    continue;
                }
                break; // 일자가 유효하면 반복문 종료
            }

            return year + month + day; // 유효한 날짜가 입력되면 반환
        }
    }
}