package com.cisco.training.service;

import java.util.List;

import com.cisco.training.domain.Product;

public interface ProductService {
	
	public int addNewProduct(Product toBeAdded);
	public void removeExisting(int id);
	
	public Product findById(int id);
	public List<Product> findAll();

}
