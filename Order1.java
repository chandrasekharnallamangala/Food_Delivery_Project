package com.project.Model;



public class Order1
{
	private int order_id;
	private int user_id;
	private int restaurant_id;
	private int total_amount;
	private boolean status;
	private String order_date;
	private String payment_op;
	
	
	
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getPayment_op() {
		return payment_op;
	}
	public void setPayment_op(String payment_op) {
		this.payment_op = payment_op;
	}
	
	
	
	public Order1(int order_id, int user_id, int restaurant_id, int total_amount, boolean status, String order_date,
			String payment_op) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.order_date = order_date;
		this.payment_op = payment_op;
	}
	
	
	
	public Order1(int user_id, int restaurant_id, int total_amount, boolean status, String order_date,
			String payment_op) {
		super();
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.order_date = order_date;
		this.payment_op = payment_op;
	}
	public Order1() {
		
	}
	
	
	
	public Order1(int user_id, int restaurant_id, int total_amount, boolean status, String payment_op) {
		super();
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.payment_op = payment_op;
	}
	
	
	@Override
	public String toString() {
		return "Order1 [order_id=" + order_id + ", user_id=" + user_id + ", restaurant_id=" + restaurant_id
				+ ", total_amount=" + total_amount + ", status=" + status + ", order_date=" + order_date
				+ ", payment_op=" + payment_op + "]";
	}
	
	
	
	
	
	
	
	
}
