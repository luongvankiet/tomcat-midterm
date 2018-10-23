package com.midterm.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.midterm.SubCategory.SubCategory;
import com.midterm.SubCategory.SubCategoryDao;

public class ProductDao {
	SubCategoryDao subDao = new SubCategoryDao();
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
			rs = stmt.executeQuery("SELECT * FROM products");
			while(rs.next()) {
				SubCategory subCate = subDao.getSubCategory(rs.getInt("subCatID"));
				prodList.add(new Product(rs.getInt("prodID"), rs.getString("prodName"), rs.getString("prodDetail"),rs.getString("image"), 
						rs.getInt("prodQty"), rs.getInt("price"), subCate));
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
	
	public Product getProduct(int prodID) {
		List<Product> prodList = getAllProducts();
		for(Product prod: prodList) {
			if(prodID == prod.getProductID()) {
				return prod;
			}
		}
		return null;
	}
	
	public List<Product> getProductBySubCategory(int subCatID){
		List<Product> prodList = getAllProducts();
		List<Product> productList = new ArrayList<Product>();
		for(Product product: prodList) {
			if(subCatID == product.getSubCategory().getSubCatID()) {
				productList.add(product);
			}
		}
		return productList;
	}
}
