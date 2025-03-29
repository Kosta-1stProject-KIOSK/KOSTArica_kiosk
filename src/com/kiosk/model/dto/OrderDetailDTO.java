package com.kiosk.model.dto;

/**
 * 주문상세정보 order_detail 테이블
 */
public class OrderDetailDTO {

	private int orderDetailNo;
	private int quantity;
    private int menuNo;
    private int basicPrice;
    private int totalExtraFee;

    private MenuOptionDTO menuOption;

    
    
    //Constructor
	public OrderDetailDTO(int orderDetailNo, int quantity, int menuNo, int basicPrice, int totalExtraFee,
			MenuOptionDTO menuOption) {
		super();
		this.orderDetailNo = orderDetailNo;
		this.quantity = quantity;
		this.menuNo = menuNo;
		this.basicPrice = basicPrice;
		this.totalExtraFee = totalExtraFee;
		this.menuOption = menuOption;
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

	public MenuOptionDTO getMenuOption() {
		return menuOption;
	}
	public void setMenuOption(MenuOptionDTO menuOption) {
		this.menuOption = menuOption;
	}
    
    
    
    
    
    
    
}
