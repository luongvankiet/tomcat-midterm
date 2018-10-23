package com.midterm.Order;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("services")
public class OrderServices {
	OrderDao orderDao = new OrderDao();
	
	@GET
	@Path("orders")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getAllOrders(){
		return orderDao.getAllOrders();
	}
	
	@GET
	@Path("orders/{orderID}/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersByUserID(@PathParam("orderID") int orderID, @PathParam("userID") int userID){
		return orderDao.getOrderByUserID(orderID, userID);
	}

	@GET
	@Path("order_detail/{orderID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderDetail> getAllOrderDetails(@PathParam("orderID") int orderID){
		return orderDao.getAllOrderDetail(orderID);
	}
	
	@POST
	@Path("orders")
	@Produces(MediaType.APPLICATION_JSON)
	public Order createOrder(Order order){
		return orderDao.createOrder(order);
	}
	

	@POST
	@Path("order_detail/{orderID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderDetail> createOrderDetail(@PathParam("orderID") int orderID, OrderDetail orderDetail){
		return orderDao.createOrderDetail(orderID, orderDetail);
	}
	
	@POST
	@Path("sendEmail")
	public void sendEmail(Order order){
		orderDao.sendEmail(order);
	}
}
