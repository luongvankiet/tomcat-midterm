package com.midterm.Category;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("services")
public class CategoryServices {
	CategoryDao categoryDao = new CategoryDao();
	
	@GET
	@Path("categories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategories(){
		return categoryDao.getAllCategories();
	}
}
