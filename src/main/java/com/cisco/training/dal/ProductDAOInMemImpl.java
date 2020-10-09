package com.cisco.training.dal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cisco.training.domain.Product;

//@Repository
public class ProductDAOInMemImpl implements ProductDAO{
	
	Map<Integer,Product> db = new HashMap<>();
	int idSequence = 0;
	
	@Override
	public Product save(Product toBeSaved) {
		int id = ++idSequence;
		toBeSaved.setId(id);
		db.put(id, toBeSaved);
		return toBeSaved;
	}
	
	@Override
	public Product findById(int id) {
		
		return db.get(id);
	}
	
	@Override
	public List<Product> findAll() {
		Collection<Product> values = db.values();
		return new ArrayList<>(values);
	}
	
	@Override
	public void deleteById(int id) {
		db.remove(id);
		
	}

}
