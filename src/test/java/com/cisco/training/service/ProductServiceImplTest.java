package com.cisco.training.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cisco.training.dal.ProductDAOInMemImpl;
import com.cisco.training.domain.Product;

public class ProductServiceImplTest {

	@Test
	public void addNewProduct_Must_Return_Valid_Id_When_ProductValue_GTEQ_MinValue() {
		
		//AAA
		//Arrange
		Product toBePassedAsArg = new Product("test", 10001, 1);
		ProductServiceImpl objUnderTest = new ProductServiceImpl();
		
		ProductDAOInMemImpl dummyDAO = new ProductDAOInMemImpl();
		objUnderTest.setDao(dummyDAO);
		
		//Act
		int id = objUnderTest.addNewProduct(toBePassedAsArg);
		//Assert
		assertTrue(id>0);
		
	}

}
