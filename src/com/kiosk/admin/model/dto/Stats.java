package com.kiosk.admin.model.dto;

/**
 * 통계 분석용 DTO
 */
public class Stats {

	private String menuName;
	private int totalSales;
    private int quantitySold;
    private String periodStart;
    private String periodEnd;
    
    public Stats() {}
	public Stats(String menuName, int totalSales, int quantitySold, String periodStart,
			String periodEnd) {
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
	
	public String getPeriodStart() {
		return periodStart;
	}
	public void setPeriodStart(String periodStart) {
		this.periodStart = periodStart;
	}
	
	public String getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(String periodEnd) {
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
