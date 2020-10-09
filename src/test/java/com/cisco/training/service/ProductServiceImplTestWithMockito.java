package com.cisco.training.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.cisco.training.dal.ProductDAO;
import com.cisco.training.dal.ProductDAOInMemImpl;
import com.cisco.training.domain.Product;

public class ProductServiceImplTestWithMockito {

	@Test
	public void addNewProduct_Must_Return_Valid_Id_When_ProductValue_GTEQ_MinValue() {
		
		//AAA
		//Arrange
		Product toBePassedAsArg = new Product("test", 10001, 1);
		ProductServiceImpl objUnderTest = new ProductServiceImpl();
		Product toBeReturnedByMock = new Product("test", 10001, 1);
		toBeReturnedByMock.setId(1);
		
		ProductDAO mockDAO = Mockito.mock(ProductDAO.class);
		Mockito.when(mockDAO.save(toBePassedAsArg)).thenReturn(toBeReturnedByMock);
		
		objUnderTest.setDao(mockDAO);
		//Act
		int id = objUnderTest.addNewProduct(toBePassedAsArg);
		//Assert
		assertTrue(id>0);
		
	}

}
