package com.midterm.Category;

public class Category {
	private int categoryID;
	private String categoryName;
	
	public Category() {}
	
	public Category(int categoryID, String categoryName) {
		this.setCategoryID(categoryID);
		this.setCategoryName(categoryName);
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


}
