package com.greedy.section01.crud.model.dto;

public class MenuDTO {
	
	private int code;
	private String name;
	private int price;
	private int categoryCode;
	private String orderableStatus;
	
	public MenuDTO() {}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public String getOrderableStatus() {
		return orderableStatus;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public void setOrderableStatus(String orderableStatus) {
		this.orderableStatus = orderableStatus;
	}

	@Override
	public String toString() {
		return "MenuDTO [code=" + code + ", name=" + name + ", price=" + price + ", categoryCode=" + categoryCode
				+ ", orderableStatus=" + orderableStatus + "]";
	}

	public MenuDTO(int code, String name, int price, int categoryCode, String orderableStatus) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.categoryCode = categoryCode;
		this.orderableStatus = orderableStatus;
	}
	

}
