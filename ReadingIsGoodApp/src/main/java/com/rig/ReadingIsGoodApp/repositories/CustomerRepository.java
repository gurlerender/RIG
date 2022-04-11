package com.rig.ReadingIsGoodApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rig.ReadingIsGoodApp.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	Customer findCustomerById(String id);
	
	Customer findCustomerByEmail(String email);
}
