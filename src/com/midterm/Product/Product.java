package com.midterm.Product;

import com.midterm.SubCategory.SubCategory;

public class Product{
	private int productID;
	private String productName;
	private String productDetail;
	private int prodQty;
	private int price;
	private String image;
	private SubCategory subCategory;
	public Product() {}
	
	public Product(int productID, String productName, String productDetail, String image,int prodQty, int price, SubCategory subCategory) {
		this.productID  = productID;
		this.productName  = productName;
		this.productDetail  = productDetail;
		this.image = image;
		this.price = price;
		this.prodQty = prodQty;
		this.subCategory = subCategory;
		
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

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	
	
}
