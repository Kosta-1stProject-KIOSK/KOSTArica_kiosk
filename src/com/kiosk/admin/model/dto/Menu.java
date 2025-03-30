package com.kiosk.admin.model.dto;

/**
 * 메뉴정보 menu, category 테이블
 */
public class Menu {

	private int menuNo;
	private String menuName;
    private int basicPrice;
    private String description;
    private String inputDate;
    private int capacity;
    private int isActive;
    private int categoryNo;
    private String categoryName;
    
    
    
    //Constructor
	public Menu(int menuNo, String menuName, int basicPrice, String description, String inputDate,
			int capacity, int isActive, String categoryName) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.basicPrice = basicPrice;
		this.description = description;
		this.inputDate = inputDate;
		this.capacity = capacity;
		this.isActive = isActive;
		this.categoryName = categoryName;
	}
	
    //Constructor
	public Menu(int menuNo, String menuName, int basicPrice, String description, String inputDate,
			int capacity, int isActive, int categoryNo, String categoryName) {
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

	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int isActive() {
		return isActive;
	}
	public void setActive(int isActive) {
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
		builder.append(menuNo);
		builder.append(" | ");
		builder.append(menuName);
		builder.append(" | ");
		builder.append(basicPrice);
		builder.append(" | ");
		builder.append(description);
		builder.append(" | ");
		builder.append(inputDate);
		builder.append(" | ");
		builder.append(capacity);
		builder.append(" | ");
		builder.append(isActive);
		builder.append(" | ");
		builder.append(categoryNo);
		builder.append(" | ");
		builder.append(categoryName);
		return builder.toString();
	}
	
   
}
