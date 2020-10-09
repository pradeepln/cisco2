package com.cisco.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cisco.training.domain.Product;

@Repository
@Transactional
public class ProductDAOJpaImpl implements ProductDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public Product save(Product toBeSaved) {
		em.persist(toBeSaved);
		return toBeSaved;
	}

	@Override
	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public List<Product> findAll() {
		Query q = em.createQuery("select p from Product as p");
		return q.getResultList();
	}

	@Override
	public void deleteById(int id) {
		Product p = em.find(Product.class, id);
		if(p != null) {
			em.remove(p);
		}
		
	}

}