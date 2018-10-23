package com.midterm.SubCategory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.midterm.Category.Category;
import com.midterm.Category.CategoryDao;


public class SubCategoryDao {
	CategoryDao categoryDao = new CategoryDao();
	public List<SubCategory> getAllSubCate() {
		List<SubCategory> subCateList = new ArrayList<SubCategory>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost:3306/eStore";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM sub_categories");
			while(rs.next()) {
				Category category = categoryDao.getCategory(rs.getInt("categoryID"));
				subCateList.add(new SubCategory(rs.getInt("subCatID"), rs.getString("subCatName"), category));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		return subCateList;
	}
	
	public SubCategory getSubCategory(int subCatID) {
		List<SubCategory> subCateList = getAllSubCate();
		for(SubCategory subCate: subCateList) {
			if(subCatID == subCate.getSubCatID()) {
				return subCate;
			}
		}
		return null;
	}
}
