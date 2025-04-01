package com.kiosk.member.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kiosk.member.model.dao.MenuDAO;
import com.kiosk.member.model.dao.MenuDAOImpl;
import com.kiosk.member.model.dto.Menu;
import com.kiosk.exception.MenuNotFoundException;
import com.kiosk.exception.NotFoundException;

public class MenuSelectService {

	private final MenuDAO menuDao = new MenuDAOImpl();
	private final Scanner sc = new Scanner(System.in);
	private final Map<String, Integer> cart = new HashMap<>();
	
	
	/**
	 * 메뉴 선택창
	 */
	public Menu startMenuSelection() {
	
		int currentCategory = 1;	// 기본값으로 커피 메뉴 출력
		
		while(true) {
			try {
				
				System.out.println("\n".repeat(10));
				
				
				System.out.println("카테고리 변경 [A: 커피 / B: 음료 / C: 푸드]");
				List<Menu> menus = printMenuByCategory(currentCategory);
				
				System.out.println("주문하실 메뉴의 [번호]를 입력해주세요.");
                System.out.print("선택: ");
                String input = sc.nextLine().trim().toUpperCase();

                switch (input) {
                //카테고리 변경
                    case "A": currentCategory = 1; continue;
                    case "B": currentCategory = 2; continue;
                    case "C": currentCategory = 3; continue;
                    case "!":
                    	System.out.println("처음 화면으로 돌아갑니다...");
                    	return null; 
                    default:
                    	//메뉴 선택   	
                        try {
                            int index = Integer.parseInt(input) - 1;
                            if (index >= 0 && index < menus.size()) {
                            	
                            	return menus.get(index);
                            	
                            } else {
                                System.out.println("없는 메뉴입니다. 다시 선택해주세요.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("잘못된 입력입니다.");
                            System.out.println("주문하실 메뉴의 번호를 입력해주세요.");
                            System.out.println("카테고리를 변경하시려면 [A: 커피 / B: 음료 / C: 푸드]를 입력해주세요.");
                        }
                }
			}catch(SQLException | NotFoundException e) {
				System.out.println("에러: 메뉴를 찾을 수 없음.");
//				e.printStackTrace();
			}
		}// while문(메뉴 선택 중)
		
		
	}// 메뉴출력
	
	
	/**
	 * 하나의 메뉴를 선택해서 반환
	 */
	public Menu returnMenu() {
		int category =1;
		try {
			List<Menu> menus = printMenuByCategory(category);
			
            System.out.println("[번호]를 입력해 메뉴를 선택하세요 (취소: 0):");
            System.out.print("선택: ");
            String input = sc.nextLine();

            int idx = Integer.parseInt(input);
            if (idx == 0) return null;
            if (idx >= 1 && idx <= menus.size()) {
                return menus.get(idx - 1);
            } else {
                System.out.println("잘못된 번호입니다.");
            }
			
		}catch(Exception e) {
			System.out.println("메뉴 선택 중 오류");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 선택한 카테고리의 메뉴들(리스트)을 반환	
	 * @param categoryNo
	 * @return
	 * @throws SQLException
	 * @throws NotFoundException
	 */
	private List<Menu> printMenuByCategory(int categoryNo) 
			throws SQLException, NotFoundException {
		
		String categories[] = {"", "커피", "음료", "푸드"};
		System.out.println("현재 카테고리: " + categories[categoryNo]);
		
		List<Menu> menus = menuDao.searchByCategory(categoryNo);
        if (menus.isEmpty()) throw new NotFoundException("현재 등록된 메뉴가 없습니다.");

        for (int i = 0; i < menus.size(); i++) {
            Menu m = menus.get(i);
            System.out.printf("%d. %s (%d원)\n	- %s\n", 
            		i + 1, m.getMenuName(), m.getBasicPrice(), m.getDescription());
        }
        
        return menus;
	}// 카테고리
	
	/**
	 * 장바구니 담기
	 * @param menu
	 */
	private void addToCart(Menu menu) {
		
		String menuName = menu.getMenuName();
		int currentCount = cart.getOrDefault(menuName, 0);
		
        cart.put(menuName, currentCount + 1);
        System.out.printf("장바구니에 [%s]가 추가되었습니다.\n",
        		menuName);
	}// addToCart : 장바구니 담기
	
	/*
	 * 장바구니
	 */
	public Map<String, Integer> getCart() {
        return cart;
    }
	
	
}//class
