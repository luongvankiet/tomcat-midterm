package com.midterm.SubCategory;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/services")
public class SubCategoryServices {
	SubCategoryDao subCatDao = new SubCategoryDao();
	@GET
	@Path("sub-categories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SubCategory> getAllSubCategories(){
		return subCatDao.getAllSubCate();
	}
	
}
