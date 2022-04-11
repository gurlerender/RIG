package com.rig.ReadingIsGoodApp.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rig.ReadingIsGoodApp.models.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
	Order findOrderById(String id);
	
	List<Order> findByCreateDateBetween(Date startDate, Date endDate);
	
	List<Order> findOrdersByCustomerId(String id);
}
