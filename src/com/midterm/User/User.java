package com.midterm.User;

public class User {
	private int userID;
	private String email;
	private String username;
	private String password;
	private String phone;
	private String address;

	public User() {}
	
	public User(int userID, String email, String username, String password, String phone, String address) {
		this.userID = userID;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
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
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
