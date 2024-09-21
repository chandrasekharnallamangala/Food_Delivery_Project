package com.project.Model;

public class OrderHistory
{
	private int order_hist_id;
	private int user_id;
	private int order_id;
	private String date;
	private int total;
	private boolean status;
	
	
	public OrderHistory(int order_hist_id, int user_id, int order_id, String date, int total, boolean status) {
		super();
		this.order_hist_id = order_hist_id;
		this.user_id = user_id;
		this.order_id = order_id;
		this.date = date;
		this.total = total;
		this.status = status;
	}


	public OrderHistory(int user_id, int order_id, int total, boolean status) {
		
		this.user_id = user_id;
		this.order_id = order_id;
		this.total = total;
		this.status = status;
	}


	public int getOrder_hist_id() {
		return order_hist_id;
	}


	public void setOrder_hist_id(int order_hist_id) {
		this.order_hist_id = order_hist_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public boolean getStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "OrderHistory [order_hist_id=" + order_hist_id + ", user_id=" + user_id + ", order_id=" + order_id
				+ ", date=" + date + ", total=" + total + ", status=" + status + "]";
	}
	
	
	
	
}
