package com.midterm.SubCategory;

import com.midterm.Category.Category;

public class SubCategory {
	private int subCatID;
	private String subCatName;
	private Category category;
	
	public SubCategory() {}
	
	public SubCategory(int subCatID, String subCatName, Category category) {
		this.setSubCatID(subCatID);
		this.setSubCatName(subCatName);
		this.setCategory(category);
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public int getSubCatID() {
		return subCatID;
	}

	public void setSubCatID(int subCatID) {
		this.subCatID = subCatID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
