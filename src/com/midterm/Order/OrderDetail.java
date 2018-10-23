package com.midterm.Order;

import com.midterm.Product.Product;

public class OrderDetail {
	private int detailID;
	private Product product;
	private int orderID;
	private int quantity;
	private int unitPrice;
	
	public OrderDetail() {}
	public OrderDetail(int detailID, Product product, int orderID, int quantity, int unitPrice) {
		this.detailID = detailID;
		this.product = product;
		this.orderID = orderID;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public int getDetailID() {
		return detailID;
	}
	public void setDetailID(int detailID) {
		this.detailID = detailID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
}
