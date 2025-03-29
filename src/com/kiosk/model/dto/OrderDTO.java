package com.kiosk.model.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 주문정보 orders 테이블
 */
public class OrderDTO {
	
	private int orderNo;
	private LocalDateTime orderTime;
    private int totalPrice;
    private boolean takeOut;
    private String memberId;
    private Integer couponNo;
    private List<OrderDetailDTO> orderDetails;
   
    
    //Constructor
    public OrderDTO(int orderNo, LocalDateTime orderTime, int totalPrice, boolean takeOut, String memberId,
    		Integer couponNo, List<OrderDetailDTO> orderDetails) {
    	super();
    	this.orderNo = orderNo;
    	this.orderTime = orderTime;
    	this.totalPrice = totalPrice;
    	this.takeOut = takeOut;
    	this.memberId = memberId;
    	this.couponNo = couponNo;
    	this.orderDetails = orderDetails;
    }
	

	
	//getter, setter
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isTakeOut() {
		return takeOut;
	}
	public void setTakeOut(boolean takeOut) {
		this.takeOut = takeOut;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(Integer couponNo) {
		this.couponNo = couponNo;
	}

	public List<OrderDetailDTO> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}



	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDTO [orderNo=");
		builder.append(orderNo);
		builder.append(", orderTime=");
		builder.append(orderTime);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", takeOut=");
		builder.append(takeOut);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", couponNo=");
		builder.append(couponNo);
		builder.append(", orderDetails=");
		builder.append(orderDetails);
		builder.append("]");
		return builder.toString();
	}


	
    

	
    
    
}
