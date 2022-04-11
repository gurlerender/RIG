package com.rig.ReadingIsGoodApp.helper;

import com.rig.ReadingIsGoodApp.models.Customer;
import com.rig.ReadingIsGoodApp.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerHelper {
	
	private final CustomerRepository customerRepository;
	
	//mail address must be unique control
	public void validateCustomerRegistiration(String mail) {
		Customer customer = customerRepository.findCustomerByEmail(mail);
		if(customer != null) {
			
		}
    }

}
