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
    
    private int rank; //순위
    
    private int totalDaily; //일간 총매출
    private int totalWeekly; //주간 총매출
    private int totalMonthly; //월간 총매출
    
    private int orderHour; //주문시간대
    
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
	
	/**
	 * 메뉴별 판매 수 통계에 사용
	 */
	public Stats(int rank, String menuName, int quantitySold) {
		super();
		this.rank = rank;
		this.menuName = menuName;
		this.quantitySold = quantitySold;
	}
	
	/**
	 * 총매출 통계에 사용
	 */
	public Stats(int totalDaily, int totalWeekly, int totalMonthly) {
		super();
		this.totalDaily = totalDaily;
		this.totalWeekly = totalWeekly;
		this.totalMonthly = totalMonthly;
	}
	
	/**
	 * 시간대별 주문수 통계에 사용
	 */
	public Stats(int orderHour, int totalSales) {
		super();
		this.orderHour = orderHour;
		this.totalSales = totalSales;
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
	
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getTotalDaily() {
		return totalDaily;
	}
	public void setTotalDaily(int totalDaily) {
		this.totalDaily = totalDaily;
	}
	public int getTotalWeekly() {
		return totalWeekly;
	}
	public void setTotalWeekly(int totalWeekly) {
		this.totalWeekly = totalWeekly;
	}
	public int getTotalMonthly() {
		return totalMonthly;
	}
	public void setTotalMonthly(int totalMonthly) {
		this.totalMonthly = totalMonthly;
	}
	
	
	public int getOrderHour() {
		return orderHour;
	}
	public void setOrderHour(int orderHour) {
		this.orderHour = orderHour;
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
