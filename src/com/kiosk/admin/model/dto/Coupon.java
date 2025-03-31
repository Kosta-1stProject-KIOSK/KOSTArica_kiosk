package com.kiosk.admin.model.dto;

/**
 * 쿠폰정보 coupon 테이블
 */
public class Coupon {

	private int couponNo;
	private String couponName;
    private int discount;
    private String validFrom;
    private String validUntil;
    private int isUsed;
    private String memberId;
    
    
    
    //constructor
    public Coupon(int couponNo, String couponName, int discount, String validFrom, String validUntil, int isUsed, String memberId) {
		super();
		this.couponNo = couponNo;
		this.couponName = couponName;
		this.discount = discount;
		this.validFrom = validFrom;
		this.validUntil = validUntil;
		this.isUsed = isUsed;
		this.memberId = memberId;
	}
    
    /**
     * 회원별 조회 시 사용
     */
    public Coupon(int couponNo, String couponName, int discount, String validFrom, String validUntil, int isUsed) {
		super();
		this.couponNo = couponNo;
		this.couponName = couponName;
		this.discount = discount;
		this.validFrom = validFrom;
		this.validUntil = validUntil;
		this.isUsed = isUsed;
	}
    
    /**
     * 쿠폰 발급 시 사용
     */
    public Coupon(String couponName, int discount, String validFrom, String validUntil, String memberId) {
		super();
		this.couponName = couponName;
		this.discount = discount;
		this.validFrom = validFrom;
		this.validUntil = validUntil;
		this.memberId = memberId;
	}
    
    
	//getter, setter
	public int getCouponNo() {return couponNo;}
	public void setCouponNo(int couponNo) {this.couponNo = couponNo;}
	
	public String getCouponName() {return couponName;}
	public void setCouponName(String couponName) {this.couponName = couponName;}
	
	public int getDiscount() {return discount;}
	public void setDiscount(int discount) {this.discount = discount;}
	
	public String getValidFrom() {return validFrom;}
	public void setValidFrom(String validFrom) {this.validFrom = validFrom;}
	
	public String getValidUntil() {return validUntil;}
	public void setValidUntil(String validUntil) {this.validUntil = validUntil;}
	
	public int getIsUsed() {return isUsed;}
	public void setIsUsed(int isUsed) {this.isUsed = isUsed;}
	
	public String getMemberId() {return memberId;}
	public void setMemberId(String memberId) {this.memberId = memberId;}


	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(couponNo);
		builder.append(" | ");
		builder.append(couponName);
		builder.append(" | ");
		builder.append(discount);
		builder.append(" | ");
		builder.append(validFrom);
		builder.append(" | ");
		builder.append(validUntil);
		builder.append(" | ");
		builder.append(isUsed);
		builder.append(" | ");
		builder.append(memberId);
		return builder.toString();
	}
	
	/**
	 * 회원별 쿠폰 조회 시 사용
	 */
	public String toStringForSearchByMember() {
        StringBuilder builder = new StringBuilder();
        builder.append(couponNo);
        builder.append(" | ");
        builder.append(couponName);
        builder.append(" | ");
        builder.append(discount);
        builder.append(" | ");
        builder.append(validFrom);
        builder.append(" | ");
        builder.append(validUntil);
        builder.append(" | ");
        builder.append(isUsed);
        return builder.toString();
    }
    
}