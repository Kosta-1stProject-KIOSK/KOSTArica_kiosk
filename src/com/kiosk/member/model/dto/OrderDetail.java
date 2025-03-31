package com.kiosk.member.model.dto;

import com.kiosk.admin.model.dto.MenuOption;

/**
 * 주문상세정보 order_detail 테이블
 */
public class OrderDetail {

	private int orderDetailNo;
	private int quantity;
	private int orderNo;
    private int menuNo;
    private int basicPrice;
    private int totalExtraFee;
    
    private MenuOption menuOption;
    
	public OrderDetail(int orderDetailNo, int quantity, int orderNo, int menuNo, int basicPrice, int totalExtraFee) {
		super();
		this.orderDetailNo = orderDetailNo;
		this.quantity = quantity;
		this.orderNo = orderNo;
		this.menuNo = menuNo;
		this.basicPrice = basicPrice;
		this.totalExtraFee = totalExtraFee;
	}

	public int getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(int orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public int getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(int basicPrice) {
		this.basicPrice = basicPrice;
	}

	public int getTotalExtraFee() {
		return totalExtraFee;
	}

	public void setTotalExtraFee(int totalExtraFee) {
		this.totalExtraFee = totalExtraFee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetailDTO [orderDetailNo=");
		builder.append(orderDetailNo);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", menuNo=");
		builder.append(menuNo);
		builder.append(", basicPrice=");
		builder.append(basicPrice);
		builder.append(", totalExtraFee=");
		builder.append(totalExtraFee);
		builder.append("]");
		return builder.toString();
	}
    
}
