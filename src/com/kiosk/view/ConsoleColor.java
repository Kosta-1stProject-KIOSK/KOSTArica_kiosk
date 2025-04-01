package com.kiosk.view;

/**
 * 콘솔 출력을 위한 변수 인터페이스
 */
public interface ConsoleColor {

    // 글자 색상
    public static final String tBLACK = "\033[30m"; // 검정
    public static final String tRED = "\033[31m"; // 빨강
    public static final String tGREEN = "\033[32m"; // 초록
    public static final String tYELLOW = "\033[33m"; // 노랑
    public static final String tBLUE = "\033[34m"; // 파랑
    public static final String tMAGENTA = "\033[35m"; // 자주색
    public static final String tCYAN = "\033[36m"; // 청록색
    public static final String tWHITE = "\033[37m"; // 흰색
    public static final String tBROWN = "\033[38;5;94m"; // 갈색 
    public static final String tCREAM = "\033[38;5;230m"; // 크림색 

    // 배경 색상
    public static final String bRED = "\033[41m"; // 빨강 배경
    public static final String bGREEN = "\033[42m"; // 초록 배경
    public static final String bYELLOW = "\033[43m"; // 노란 배경
    public static final String bBLUE = "\033[44m"; // 파랑 배경
    public static final String bMAGENTA = "\033[45m"; // 자주색 배경
    public static final String bCYAN = "\033[46m"; // 청록색 배경
    public static final String bWHITE = "\033[47m"; // 흰색 배경
    public static final String bBROWN = "\033[48;5;94m"; // 갈색 배경
    public static final String bCREAM = "\033[48;5;230m"; // 크림색 배경

    // 특수효과
    public static final String BOLD = "\033[1m"; // 굵게
    public static final String UNDERLINE = "\033[4m"; // 밑줄
    // 효과 초기화
    public static final String RESET = "\033[0m";
}
