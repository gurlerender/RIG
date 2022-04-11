package com.rig.ReadingIsGoodApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rig.ReadingIsGoodApp.helper.Constants;
import com.rig.ReadingIsGoodApp.models.Customer;
import com.rig.ReadingIsGoodApp.repositories.CustomerRepository;
import com.rig.ReadingIsGoodApp.serviceparam.ServiceResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	public ServiceResponse<Customer> saveCustomer(Customer customer) {
		Customer currentCustomer = customerRepository.findCustomerByEmail(customer.getEmail());
		if(currentCustomer != null) {
			return new ServiceResponse<Customer>(false, Constants.THERE_IS_A_CUSTOMER_REGISTERED_THIS_EMAIL,customer);
		}
			
		customerRepository.insert(customer);
		//return ServiceResponse.builder().isSuccessful(true).message(Constants.NEW_REGISTRATION_COMPLETED).build();
		return new ServiceResponse<Customer>(true, Constants.NEW_REGISTRATION_COMPLETED,customer);
    }

	public List<Customer> getAllCustomers() {	        
		return customerRepository.findAll();
	}
	
	public Customer findCustomerByEmail(Customer customer) {
		Customer currentCustomer = customerRepository.findCustomerByEmail(customer.getEmail());
		return currentCustomer;
	}
	
	public Customer findCustomerById(String id) {
		Customer currentCustomer = customerRepository.findCustomerById(id);
		return currentCustomer;
	}
	
	
}
