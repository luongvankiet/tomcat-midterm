package com.midterm.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.midterm.Product.Product;
//import com.midterm.Product.Product;
import com.midterm.Product.ProductDao;
import com.midterm.User.User;
import com.midterm.User.UserDao;


public class OrderDao {
	UserDao userDao = new UserDao();
	ProductDao productDao = new ProductDao();
	
	public List<Order> getAllOrders(){
		List<Order> orderList = new ArrayList<Order>();
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
			rs = stmt.executeQuery("SELECT * FROM orders");
			while(rs.next()) {
				User user = userDao.getUser(rs.getInt("userID"));
				orderList.add(new Order(rs.getInt("orderID"), user, rs.getInt("total"), rs.getString("created_at")));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		return orderList;
	}
	
	public List<OrderDetail> getAllOrderDetail(int orderID){
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost:3306/eStore";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			String sql = "SELECT * FROM orders, order_detail where orders.orderID = order_detail.orderID "
					+ "and order_detail.orderID = (?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderID);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Product prod= productDao.getProduct(rs.getInt("productID"));
				orderDetailList.add(new OrderDetail(rs.getInt("detailID"), prod, rs.getInt("orderID"), rs.getInt("quantity"), rs.getInt("unit_price")));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		return orderDetailList;
	}
	
	public Order getOrder(int orderID) {
		List<Order> orderList = getAllOrders();
		for(Order order: orderList) {
			if(orderID == order.getOrderID()) {
				return order;
			}
		}
		return null;
	}
	
	
	public List<Order> getOrderByUserID(int orderID, int userID) {
		List<Order> orderList = getAllOrders();
		List<Order> uOrderList = new ArrayList<Order>();
		for(Order order: orderList) {
			if(userID == order.getUser().getUserID() && orderID == order.getOrderID()) {
				uOrderList.add(order);
			}
		}
		return uOrderList;
	}
	
	public Order createOrder(Order order) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int LAST_INSERTED_ORDERID;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost:3306/eStore";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			String sql = "insert into orders value(null,?,?,?)";
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, order.getUser().getUserID());
			stmt.setInt(2, order.getTotal());
			stmt.setString(3, getNow());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			rs.next();
			LAST_INSERTED_ORDERID = rs.getInt(1);
			return getOrder(LAST_INSERTED_ORDERID);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		return null;
	}
	
	public List<OrderDetail> createOrderDetail(int orderID, OrderDetail orderDetail) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost:3306/eStore";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			String sql1 = "insert into order_detail value(null,?,?,?,?)";
			stmt = conn.prepareStatement(sql1);
			stmt.setInt(1, orderDetail.getProduct().getProductID());
			stmt.setInt(2, orderID);
			stmt.setInt(3, orderDetail.getQuantity());
			stmt.setInt(4, orderDetail.getProduct().getPrice());
			stmt.executeUpdate();
			stmt.close();
			
			Product product = productDao.getProduct(orderDetail.getProduct().getProductID());
			int prodQty = product.getProdQty() - orderDetail.getQuantity();
			String sql2 = "update products set prodQty = (?) where prodID = (?)";
			stmt = conn.prepareStatement(sql2);
			stmt.setInt(1, prodQty);
			stmt.setInt(2, orderDetail.getProduct().getProductID());
			stmt.executeUpdate();
			return getAllOrderDetail(orderID);
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace();}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace();}
		}
		return null;
	}
	

	public void sendEmail(Order order)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String email = order.getUser().getEmail();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost:3306/estore";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users WHERE email='" + email + "'");
			while (rs.next())
			{
				String userEmail = rs.getString("email");
				emailHandler(userEmail, order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	private void emailHandler(String email, Order order)
	{
		//change username and password to test
		final String username = "example@gmail.com";
		final String password = "password";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

		try {

			List<OrderDetail> orderList = getAllOrderDetail(order.getOrderID());
			StringBuilder msg = new StringBuilder();
			msg.append("Dear " + email + ",");
			msg.append("\n\nYou buy these items at " + getNow());
			for(OrderDetail orderDetail: orderList){
				msg.append("\n\t - Product name: "+orderDetail.getProduct().getProductName()+ "\tQuantity: " +orderDetail.getQuantity() + "\tUnit price: " +orderDetail.getUnitPrice());
			}
			msg.append("\nTotal: " + order.getTotal()
					+ "\nRegards,");
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("admin@example.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Order confirmation");
			message.setText(msg.toString());

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	
	public String getNow() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
