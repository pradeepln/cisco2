package com.cisco.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cisco.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductappApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer  = 
				SpringApplication.run(ProductappApplication.class, args);
//		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//		ui.createProductWithUI();
	}

}
