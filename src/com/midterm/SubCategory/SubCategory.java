package com.midterm.SubCategory;

public class SubCategory {
	private int subCatID;
	private String subCatName;
	private int categoryID;
	
	public SubCategory() {}
	
	public SubCategory(int subCatID, String subCatName, int categoryID) {
		this.setSubCatID(subCatID);
		this.setSubCatName(subCatName);
		this.setCategoryID(categoryID);
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

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
}
