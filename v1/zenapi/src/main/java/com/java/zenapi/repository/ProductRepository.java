package com.java.zenapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.java.zenapi.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p where p.description like %?1%")
	List<Product> searchProducts(String search);

}
