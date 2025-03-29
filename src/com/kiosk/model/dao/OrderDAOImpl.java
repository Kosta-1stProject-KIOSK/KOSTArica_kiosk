package com.kiosk.model.dao;

import java.util.List;

import com.kiosk.model.dto.OrderDTO;

public class OrderDAOImpl implements OrderDAO {

	/**
	 * 주문 등록. 주문 상세 및 옵션 정보 포함.
	 * @param order (등록할 주문 정도 OrderDTO order)
	 */
	@Override
	public void insert(OrderDTO order) {
		// TODO Auto-generated method stub
		
	}

	
	
	/**
     * 주문번호로 주문 정보 조회
     * @param orderNo 주문번호
     * @return 주문정보(OrderDTO)
     */
	@Override
	public OrderDTO searchById(int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 특정 회원의 주문 목록을 조회
     * @param memberId (회원번호)
     * @return 해당 회원의 주문 리스트(List<OrderDTO>)
     */
	@Override
	public List<OrderDTO> searchByMember(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 전체 주문 조회
     * @return 전체 주문 리스트(List<OrderDTO>)
     */
	@Override
	public List<OrderDTO> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 이건 넣을지 말지 고민중! 주문을 삭제할 필요가 있나?
     * 주문 삭제
     * @param orderNo (삭제할 주문 번호)
     */
	@Override
	public void delete(int orderNo) {
		// TODO Auto-generated method stub
		
	}

}
