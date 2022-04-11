package com.rig.ReadingIsGoodApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rig.ReadingIsGoodApp.models.Customer;
import com.rig.ReadingIsGoodApp.service.CustomerService;

@SpringBootTest
public class CustomerControllerUnitTest {
	 @Autowired
	 private CustomerService customerService;
	 
	 @Test
	 public void customerUpdateTest() {
		 Customer customer = new Customer("Test","Tester","1234","test@email.com"
				 ,"testAdres","5051112233");
	     customerService.saveCustomer(customer);
	 }
	 
	
}
