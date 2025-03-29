package com.kiosk.model.dto;

import java.time.LocalDate;

/**
 * 쿠폰정보 coupon 테이블
 */
public class CouponDTO {

	private int couponNo;
	private String couponName;
    private int discount;
    private LocalDate validFrom;
    private LocalDate validUntil;
    private int isUsed;
    private String memberId;
    
    
    
    //constructor
    public CouponDTO(int couponNo, String couponName, int discount, LocalDate validFrom, LocalDate validUntil, int isUsed, String memberId) {
		super();
		this.couponNo = couponNo;
		this.couponName = couponName;
		this.discount = discount;
		this.validFrom = validFrom;
		this.validUntil = validUntil;
		this.isUsed = isUsed;
		this.memberId = memberId;
	}
    
    
    
	//getter, setter
	public int getCouponNo() {return couponNo;}
	public void setCouponNo(int couponNo) {this.couponNo = couponNo;}
	
	public String getCouponName() {return couponName;}
	public void setCouponName(String couponName) {this.couponName = couponName;}
	
	public int getDiscount() {return discount;}
	public void setDiscount(int discount) {this.discount = discount;}
	
	public LocalDate getValidFrom() {return validFrom;}
	public void setValidFrom(LocalDate validFrom) {this.validFrom = validFrom;}
	
	public LocalDate getValidUntil() {return validUntil;}
	public void setValidUntil(LocalDate validUntil) {this.validUntil = validUntil;}
	
	public int getIsUsed() {return isUsed;}
	public void setIsUsed(int isUsed) {this.isUsed = isUsed;}
	
	public String getMemberId() {return memberId;}
	public void setMemberId(String memberId) {this.memberId = memberId;}


	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CouponDTO [couponNo=");
		builder.append(couponNo);
		builder.append(", couponName=");
		builder.append(couponName);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", validFrom=");
		builder.append(validFrom);
		builder.append(", validUntil=");
		builder.append(validUntil);
		builder.append(", isUsed=");
		builder.append(isUsed);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append("]");
		return builder.toString();
	}
    
	
	
	
    
    
    
}