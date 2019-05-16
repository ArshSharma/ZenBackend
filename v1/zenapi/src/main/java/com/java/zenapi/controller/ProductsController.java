package com.java.zenapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.zenapi.model.Product;
import com.java.zenapi.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value="products")
public class ProductsController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Product> getAllItems(){
		return productService.getAllItems();
	}
	
	@RequestMapping(value="/getFiltered/{searchString}", method=RequestMethod.GET)
	public List<Product> getFilteredProducts(@PathVariable String searchString ){
		return productService.getFilteredProducts(searchString);
		
	}
}
