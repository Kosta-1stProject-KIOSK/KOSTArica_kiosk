package com.kiosk.model.dto;

import java.time.LocalDateTime;

/**
 * 통계 분석용 DTO
 */
public class StatsDTO {

	private String menuName;
	private int totalSales;
    private int quantitySold;
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
    
    public StatsDTO() {}
	public StatsDTO(String menuName, int totalSales, int quantitySold, LocalDateTime periodStart,
			LocalDateTime periodEnd) {
		super();
		this.menuName = menuName;
		this.totalSales = totalSales;
		this.quantitySold = quantitySold;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}
	
	
	//getter, setter
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	
	public LocalDateTime getPeriodStart() {
		return periodStart;
	}
	public void setPeriodStart(LocalDateTime periodStart) {
		this.periodStart = periodStart;
	}
	
	public LocalDateTime getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(LocalDateTime periodEnd) {
		this.periodEnd = periodEnd;
	}
	
	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatsDTO [menuName=");
		builder.append(menuName);
		builder.append(", totalSales=");
		builder.append(totalSales);
		builder.append(", quantitySold=");
		builder.append(quantitySold);
		builder.append(", periodStart=");
		builder.append(periodStart);
		builder.append(", periodEnd=");
		builder.append(periodEnd);
		builder.append("]");
		return builder.toString();
	}
	
    
    
	
}
