package com.midterm.User;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("services")
public class UserServices {
	
	UserDao userDao = new UserDao();
	
	@GET
	@Path("users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	@GET
	@Path("users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") int id){
		return userDao.getUser(id);
	}
	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(User u){
		List<User> userList = userDao.getAllUsers();
		for(User user: userList) {
			if(u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
				return Response.ok(user).build();
			}
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("Login failed!").build();
	}
}
