package com.kiosk.member.model.dto;

/**
 * 고객이 주문을 할 때 사용할 Menu 정보
 */
public class Menu {

	private int menuNo;
    private String menuName;
    private int basicPrice;
    private String categoryName;
    private String description;
    
	public Menu(int menuNo, String menuName, int basicPrice, String description,String categoryName ) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.basicPrice = basicPrice;
		this.categoryName = categoryName;
		this.description = description;
	}

	
	
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

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", menuName=" + menuName + ", basicPrice=" + basicPrice + ", categoryName="
				+ categoryName + ", description=" + description + "]";
	}
	
	
    
}
