package com.kiosk.model.dto;

import java.time.LocalDateTime;

/**
 * 메뉴정보 menu, category 테이블
 */
public class MenuDTO {

	private int menuNo;
	private String menuName;
    private int basicPrice;
    private String description;
    private LocalDateTime inputDate;
    private int capacity;
    private boolean isActive;
    private int categoryNo;
    private String categoryName;
    
    
    
    //Constructor
	public MenuDTO(int menuNo, String menuName, int basicPrice, String description, LocalDateTime inputDate,
			int capacity, boolean isActive, int categoryNo, String categoryName) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.basicPrice = basicPrice;
		this.description = description;
		this.inputDate = inputDate;
		this.capacity = capacity;
		this.isActive = isActive;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}


	//getter, setter
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(int basicPrice) {
		this.basicPrice = basicPrice;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getInputDate() {
		return inputDate;
	}
	public void setInputDate(LocalDateTime inputDate) {
		this.inputDate = inputDate;
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuDTO [menuNo=");
		builder.append(menuNo);
		builder.append(", menuName=");
		builder.append(menuName);
		builder.append(", basicPrice=");
		builder.append(basicPrice);
		builder.append(", description=");
		builder.append(description);
		builder.append(", inputDate=");
		builder.append(inputDate);
		builder.append(", capacity=");
		builder.append(capacity);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", categoryNo=");
		builder.append(categoryNo);
		builder.append(", categoryName=");
		builder.append(categoryName);
		builder.append("]");
		return builder.toString();
	}
	
   
}
