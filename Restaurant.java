package com.project.Model;

public class Restaurant
{
	private int restaurant_Id;
	private String name;
	private String cuisine_type;
	private int delivery_Time;
	private boolean isActive;
	private int rating;
	private String imgPathString;
	
	
	public int getRestaurant_Id() {
		return restaurant_Id;
	}
	public void setRestaurant_Id(int restaurant_Id) {
		this.restaurant_Id = restaurant_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisine_type() {
		return cuisine_type;
	}
	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}
	public int getDelivery_Time() {
		return delivery_Time;
	}
	public void setDelivery_Time(int delivery_Time) {
		this.delivery_Time = delivery_Time;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getImgPathString() {
		return imgPathString;
	}
	public void setImgPathString(String imgPathString) {
		this.imgPathString = imgPathString;
	}
	public Restaurant(int restaurant_Id, String name, String cuisine_type, int delivery_Time, boolean isActive,
			int rating, String imgPathString) {
		super();
		this.restaurant_Id = restaurant_Id;
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.delivery_Time = delivery_Time;
		this.isActive = isActive;
		this.rating = rating;
		this.imgPathString = imgPathString;
	}
	
	
	public Restaurant(String name, String cuisine_type, int delivery_Time, boolean isActive, int rating,
			String imgPathString) {
		super();
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.delivery_Time = delivery_Time;
		this.isActive = isActive;
		this.rating = rating;
		this.imgPathString = imgPathString;
	}
	public Restaurant() {
		super();
	}
	@Override
	public String toString() {
		return "Restaurant [restaurant_Id=" + restaurant_Id + ", name=" + name + ", cuisine_type=" + cuisine_type
				+ ", delivery_Time=" + delivery_Time + ", isActive=" + isActive + ", rating=" + rating
				+ ", imgPathString=" + imgPathString + "]";
	}
	
	
	
	
	
	
	
}
