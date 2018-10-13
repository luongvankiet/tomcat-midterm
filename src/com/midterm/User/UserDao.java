package com.midterm.User;

import java.util.*;

import javax.ws.rs.core.Response;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
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
			rs = stmt.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				userList.add(new User(rs.getInt("userID"), rs.getString("email"), rs.getString("username"), rs.getString("password"), 
						rs.getString("phone"), rs.getString("address")));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		return userList;
	}
	
	//get User by id
	public Response getUser(int id) {
		List<User> userList = getAllUsers();
		for(User user: userList) {
			if(id == user.getUserID()) {
				return Response.ok(user).build();
			}
		}
		return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
	}
}
