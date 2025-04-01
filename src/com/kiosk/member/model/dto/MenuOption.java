package com.kiosk.member.model.dto;

/*
 * 메뉴옵션 menu_option 테이블
 */
public class MenuOption {

	private int optionNo;
	private int menuNo;
    private String temperature;
    private String size;
    private int shot;
    private int whipping;
    private int extraFee;
    private int orderDetailNo;
    private int quantity;
    
    
    
    //생성자
	public MenuOption(int optionNo, int menuNo, String temperature, String size, int shot, int whipping, int extraFee,
			int orderDetailNo) {
		super();
		this.optionNo = optionNo;
		this.menuNo = menuNo;
		this.temperature = temperature;
		this.size = size;
		this.shot = shot;
		this.whipping = whipping;
		this.extraFee = extraFee;
		this.orderDetailNo = orderDetailNo;
	}

	public int getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public int getWhipping() {
		return whipping;
	}

	public void setWhipping(int whipping) {
		this.whipping = whipping;
	}

	public int getExtraFee() {
		return extraFee;
	}

	public void setExtraFee(int extraFee) {
		this.extraFee = extraFee;
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

	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuOption [optionNo=");
		builder.append(optionNo);
		builder.append(", menuNo=");
		builder.append(menuNo);
		builder.append(", temperature=");
		builder.append(temperature);
		builder.append(", size=");
		builder.append(size);
		builder.append(", shot=");
		builder.append(shot);
		builder.append(", whipping=");
		builder.append(whipping);
		builder.append(", extraFee=");
		builder.append(extraFee);
		builder.append(", orderDetailNo=");
		builder.append(orderDetailNo);
		builder.append("]");
		return builder.toString();
	}
	
}
