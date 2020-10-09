package com.cisco.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.training.domain.Product;
import com.cisco.training.service.ProductService;

@Component
public class ProductConsoleUI {
	
	ProductService service; // = new ProductServiceImpl();
	
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}
	
	public void createProductWithUI() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a Name: ");
		String name  = s.nextLine();
		System.out.println("Enter price: ");
		float price = Float.parseFloat(s.nextLine());
		System.out.println("Enter QoH: ");
		int qoh = Integer.parseInt(s.nextLine());
		
		Product p = new Product(name, price, qoh);
		int id = service.addNewProduct(p);
		System.out.println("Added product with Id: "+id);
	}

}
