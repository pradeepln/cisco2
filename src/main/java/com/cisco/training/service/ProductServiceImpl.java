package com.cisco.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.training.dal.ProductDAO;
import com.cisco.training.dal.ProductDAOInMemImpl;
import com.cisco.training.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

	ProductDAO dao; // = new ProductDAOInMemImpl();
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int addNewProduct(Product toBeAdded) {
		
		if(toBeAdded.getPrice() * toBeAdded.getQoh() >= 10000) {
			Product added = dao.save(toBeAdded);
			return added.getId();
		}else {
			throw new IllegalArgumentException("The monetory value is LT 10000!");
		}
		
		
	}

	@Override
	public void removeExisting(int id) {
		Product p = dao.findById(id);
		if(p != null) {
			if(p.getPrice() * p.getQoh() < 100000) {
				dao.deleteById(id);
			}else {
				throw new IllegalStateException("Value GT 100k. Can't delete!");
			}
		}
	}

	@Override
	public Product findById(int id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		
		return dao.findAll();
	}

}
