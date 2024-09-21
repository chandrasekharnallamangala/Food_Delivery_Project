package com.project.Model;

public class Menu
{
	private int menu_Id;
	private int restaurant_id;
	private String item_name;
	private String description;
	private float price;
	private boolean isAvailable;
	private String imgPath;
	public int getMenu_Id() {
		return menu_Id;
	}
	public void setMenu_Id(int menu_Id) {
		this.menu_Id = menu_Id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Menu(int menu_Id, int restaurant_id, String item_name, String description, float price, boolean isAvailable,
			String imgPath) {
		super();
		this.menu_Id = menu_Id;
		this.restaurant_id = restaurant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}
	
	
	public Menu(int restaurant_id, String item_name, String description, float price, boolean isAvailable,
			String imgPath) {
		super();
		this.restaurant_id = restaurant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}
	
	
	 public Menu(String item_name) {
	        this.item_name = item_name;
	    }
	
	
	

	@Override
	public String toString() {
		return "Menu [menu_Id=" + menu_Id + ", restaurant_id=" + restaurant_id + ", item_name=" + item_name
				+ ", description=" + description + ", price=" + price + ", isAvailable=" + isAvailable + ", imgPath="
				+ imgPath + "]";
	}
	
	
	
	
	

}
