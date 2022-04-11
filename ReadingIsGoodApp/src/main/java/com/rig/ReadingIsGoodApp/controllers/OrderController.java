package com.rig.ReadingIsGoodApp.controllers;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rig.ReadingIsGoodApp.models.Order;
import com.rig.ReadingIsGoodApp.service.OrderService;
import com.rig.ReadingIsGoodApp.serviceparam.ServiceResponse;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @RequestMapping("/saveOrder")
    public ServiceResponse<Order> saveOrder(@RequestBody Order order) {
    	ServiceResponse<Order> response = orderService.saveOrder(order);
        return response;
	}
    
    @GetMapping
    @RequestMapping("/getOrder")
    public ServiceResponse<Order> getOrder(@PathParam("id") String id) {
    	ServiceResponse<Order> response = orderService.getOrder(id);
        return response;
	}
    
    @GetMapping
    @RequestMapping("/getOrderList")
    public ServiceResponse<List<Order>> getOrderList(@PathParam("startDate") String startDate, 
    		@PathParam("endDate") String endDate) {
    	ServiceResponse<List<Order>> response = orderService.getOrderList(startDate, endDate);
        return response;
	}
    
}

