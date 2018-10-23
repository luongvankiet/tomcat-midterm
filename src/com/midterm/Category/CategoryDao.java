package com.midterm.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class CategoryDao {
	public List<Category> getAllCategories(){
		List<Category> categoryList = new ArrayList<Category>();
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
			rs = stmt.executeQuery("SELECT * FROM categories");
			while(rs.next()) {
				categoryList.add(new Category(rs.getInt("categoryID"), rs.getString("categoryName")));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		return categoryList;
	}
	
	public Category getCategory(int categoryID) {
		List<Category> cateList = getAllCategories();
		for(Category category: cateList) {
			if(categoryID == category.getCategoryID()) {
				return category;
			}
		}
		return null;
	}
}
