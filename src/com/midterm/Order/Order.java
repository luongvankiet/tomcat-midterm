package com.midterm.Order;


import com.midterm.User.User;

public class Order {
	private int orderID;
	private User user;
	private int total;
	private String created_at;
	
	public Order() {}
	public Order(int orderID, User user, int total, String created_at) {
		this.orderID = orderID;
		this.user = user;
		this.total = total;
		this.created_at = created_at;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
