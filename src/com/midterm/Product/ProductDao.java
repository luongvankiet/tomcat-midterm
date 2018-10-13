package com.midterm.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ProductDao {
	public List<Product> getAllProducts(){
		List<Product> prodList = new ArrayList<Product>();
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
			rs = stmt.executeQuery("SELECT * FROM sub_categories, products WHERE products.subCatID = sub_categories.subCatID");
			while(rs.next()) {
				prodList.add(new Product(rs.getInt("prodID"), rs.getString("prodName"), rs.getString("prodDetail"),rs.getString("image"), 
						rs.getInt("price"), rs.getInt("subCatID"), rs.getString("subCatName")));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		return prodList;
	}
}
