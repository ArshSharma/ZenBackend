package com.java.zenapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.zenapi.model.Product;

import com.java.zenapi.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepositry;
	
	public List<Product> getAllItems(){
		return (List<Product>) productRepositry.findAll();
	}
	
	public List<Product> getFilteredProducts(String searchString){
		return productRepositry.searchProducts(searchString);
	}

}
