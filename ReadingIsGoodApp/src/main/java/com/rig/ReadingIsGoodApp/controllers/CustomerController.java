package com.rig.ReadingIsGoodApp.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rig.ReadingIsGoodApp.helper.Constants;
import com.rig.ReadingIsGoodApp.models.Customer;
import com.rig.ReadingIsGoodApp.models.Order;
import com.rig.ReadingIsGoodApp.service.CustomerService;
import com.rig.ReadingIsGoodApp.service.OrderService;
import com.rig.ReadingIsGoodApp.serviceparam.ServiceResponse;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final OrderService orderService;
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }
	
	@PostMapping
    @RequestMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    @RequestMapping("/saveCustomer")
    public ServiceResponse<Customer> saveCustomer(@RequestBody Customer customer) {
    	ServiceResponse<Customer> response = customerService.saveCustomer(customer);
        return response;
	}
    
    @GetMapping
    @RequestMapping("/getOrdersForCustomer")
    public ServiceResponse<List<Order>> getOrdersForCustomer(@PathParam("id") String id) {
        Customer customer = customerService.findCustomerById(id);
        ServiceResponse<List<Order>> response = new ServiceResponse<List<Order>>();
        if (customer == null) {
        	response.setMessage(Constants.CUSTOMER_NOT_FOUND);
        	response.setSuccessful(false);
            return response;
        }

        List<Order> orders = orderService.getOrderByCustomerId(id);
        response.setSuccessful(true);
        response.setObject(orders);
        return response;
    }
}
