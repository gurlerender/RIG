package com.rig.ReadingIsGoodApp.service;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rig.ReadingIsGoodApp.helper.Constants;
import com.rig.ReadingIsGoodApp.helper.OrderStatus;
import com.rig.ReadingIsGoodApp.models.Book;
import com.rig.ReadingIsGoodApp.models.Customer;
import com.rig.ReadingIsGoodApp.models.Order;
import com.rig.ReadingIsGoodApp.models.OrderDetail;
import com.rig.ReadingIsGoodApp.repositories.OrderRepository;
import com.rig.ReadingIsGoodApp.serviceparam.ServiceResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final CustomerService customerService;
	private final BookService bookService;
	
	public ServiceResponse<Order> saveOrder(Order order) {
		List<Book> bookList = new ArrayList<Book>();
		BigDecimal totalPrice = BigDecimal.valueOf(0);
		if(order != null) {
			if(order.getOrderDetail() == null) {
				return new ServiceResponse<Order>(false, Constants.NOT_SELECTED_ORDER,order);
			}
			Customer customer = customerService.findCustomerById(order.getCustomerId());
			if(customer == null) {
				return new ServiceResponse<Order>(false, Constants.CUSTOMER_NOT_FOUND,order);
			}
			for(OrderDetail od : order.getOrderDetail()) {
				if(od.getOrderCount() <= 0) {
					return new ServiceResponse<Order>(false, Constants.ORDER_COUNT_MUST_BE_GREATER_THAN_ZERO,order);
				}
				else if(od.getBookId() != null) {
					Book book = bookService.findBookById(od.getBookId());
					if(book == null) {
						return new ServiceResponse<Order>(false, Constants.BOOK_NOT_FOUND,order);
					}
					else if(book.getStock() < od.getOrderCount()) {
						return new ServiceResponse<Order>(false, Constants.THERE_IS_NOT_ENOUGH_STOCK,order);
					}
					else {
						book.setStock(book.getStock() - od.getOrderCount());
						bookList.add(book);
						totalPrice = totalPrice.add(book.getPrice().multiply(BigDecimal.valueOf(od.getOrderCount())));
					}
				}
			}
		}
		bookService.reduceStocks(bookList);
		order.setTotalPrice(totalPrice);
		order.setStatus(OrderStatus.COMPLETED);
		order.setCreateDate(new Date(System.currentTimeMillis()));
		orderRepository.insert(order);
		return new ServiceResponse<Order>(true, Constants.ORDER_CREATED,order);
    }
	
	public ServiceResponse<Order> getOrder(String id){
		ServiceResponse<Order> response = new ServiceResponse<Order>();
		Order order = orderRepository.findOrderById(id);
		if(order == null) {
			return new ServiceResponse<Order>(false, Constants.ORDER_NOT_FOUND,order);
		}
		response.setObject(order);
		response.setSuccessful(true);
		return response;
	}
	
	public ServiceResponse<List<Order>> getOrderList(String startDate, String endDate){
		SimpleDateFormat formatter =new SimpleDateFormat("dd.MM.yyyy");  
		Date startDateDt;
		Date endDateDt;
		try {
			startDateDt = formatter.parse(startDate);
			endDateDt = (Date) formatter.parse(endDate);
			List<Order> orderList = orderRepository.findByCreateDateBetween(startDateDt, endDateDt);
			if(orderList == null) {
				return new ServiceResponse<List<Order>>(false, Constants.ORDER_NOT_FOUND,null);
			}
			return new ServiceResponse<List<Order>>(true, "", orderList);
			
		} catch (ParseException e) {
			return new ServiceResponse<List<Order>>(false, Constants.DATE_PARSE_EXCEPTION,null);
		}
		
	}
	
	public List<Order> getOrderByCustomerId(String id) {
		return orderRepository.findOrdersByCustomerId(id);
	}
	
}
