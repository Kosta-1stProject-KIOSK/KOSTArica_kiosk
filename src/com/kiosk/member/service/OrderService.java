package com.kiosk.member.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kiosk.member.model.dao.OrderDAO;
import com.kiosk.member.model.dao.OrderDAOImpl;
import com.kiosk.member.model.dto.Menu;
import com.kiosk.member.model.dto.MenuOption;
import com.kiosk.member.model.dto.Order;
import com.kiosk.member.model.dto.OrderDetail;

public class OrderService {

	private final OrderDAO orderDao = new OrderDAOImpl();
	
	/**
	 * 주문 정보 저장(주문+ 상세 + 옵션 다 포함)
	 * @param order
	 */
	public void saveOrder(Order order) {
		
		try {
            orderDao.insert(order);
            System.out.println("주문 정보가 저장되었습니다.");
        } catch (Exception e) {
            System.out.println("주문 저장 중 오류 발생: " + e.getMessage());
        }
		
	}
	
	
	
	
	/**
     * 장바구니 데이터를 Order 객체로 변환
     * @param cart 장바구니
     * @param memberId 회원 ID (비회원이면 null)
     * @param couponNo 사용한 쿠폰 번호 (없으면 null)
     * @param takeOut 테이크아웃 여부
     * @return 생성된 Order 객체
     */
    public Order createOrderFromCart(Map<Menu, MenuOption> cart, String memberId, Integer couponNo, boolean takeOut) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        int totalPrice = 0;
        int orderDetailNo = 1;

        for (Map.Entry<Menu, MenuOption> entry : cart.entrySet()) {
            Menu menu = entry.getKey();
            MenuOption option = entry.getValue();
            
            int quantity = option.getOrderDetailNo();
            if(quantity <= 0 ) quantity =1;
            
            int itemPrice = (menu.getBasicPrice() + option.getExtraFee()) * quantity;
            totalPrice += itemPrice;

            OrderDetail detail = new OrderDetail(
                orderDetailNo++,
                quantity,
                0, // orderNo는 insert 시 자동 세팅되도록
                menu.getMenuNo(),
                menu.getBasicPrice(),
                option.getExtraFee()
            );
            detail.setMenuOption(option); // 옵션 정보 세팅

            orderDetails.add(detail);
        }

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return new Order(0, now, totalPrice, takeOut, memberId, couponNo, orderDetails);
    }
	
	
	
	
	
}
