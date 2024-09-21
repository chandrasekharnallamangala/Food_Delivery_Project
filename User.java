package com.project.Model;

public class User
{
	private int user_id;
	private String user_name;
	private String password;
	private String email;
	private String address;
	private String role;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String text) {
		this.address = text;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	public User(int user_id, String user_name, String password, String email, String text, String role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.address = text;
		this.role = role;
	}
	
	
	public User(String user_name, String password, String email, String text, String role) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.address = text;
		this.role = role;
	}
	
	
	public User() {
		super();
	}
	
	
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", email=" + email
				+ ", Address=" + address + ", role=" + role + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
