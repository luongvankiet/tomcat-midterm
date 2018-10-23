package com.midterm.Product;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("services")
public class ProductServices {
	ProductDao prodDao = new ProductDao();
	
	@GET
	@Path("products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts(){
		return prodDao.getAllProducts();
	}
	
	@GET
	@Path("products/{subCatID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductBySubCategory(@PathParam("subCatID") int subCatID){
		return prodDao.getProductBySubCategory(subCatID);
	}
}
