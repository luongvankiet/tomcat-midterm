package com.midterm.Product;

import com.midterm.Category.Category;

public class Product extends Category {
	private int productID;
	private String productName;
	private String productDetail;
	private int price;
	private String image;
	
	public Product() {}
	
	public Product(int productID, String productName, String productDetail, String image, int price, int categoryID, String categoryName) {
		super(categoryID, categoryName);
		this.productID  = productID;
		this.productName  = productName;
		this.productDetail  = productDetail;
		this.image = image;
		this.price = price;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
