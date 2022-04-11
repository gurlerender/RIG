package com.rig.ReadingIsGoodApp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rig.ReadingIsGoodApp.models.Order;
import com.rig.ReadingIsGoodApp.models.OrderDetail;
import com.rig.ReadingIsGoodApp.service.OrderService;

@SpringBootTest
public class OrderControllerUnitTest {
	 @Autowired
	 private OrderService orderService;
	 
	 @Test
	 public void saveOrderTest() {
		 List<OrderDetail> odLsit = new ArrayList<OrderDetail>();
		 OrderDetail od = new OrderDetail();
		 od.setBookId("62536f2a6e008e044e0eaaf9");
		 od.setOrderCount(1);
		 odLsit.add(od);
		 OrderDetail od2 = new OrderDetail();
		 od2.setBookId("62536fa11056eb11e454a13d");
		 od2.setOrderCount(8);
		 odLsit.add(od2);
		 orderService.saveOrder(
				 new Order("6252c816ee67270d3c75a8be", BigDecimal.valueOf(0), null, null,odLsit));
	 }
	 
	 @Test
	 public void getOrderTest() {
		 orderService.getOrder("625353dd280f1f2dd096dd33");
				 
	 }
	 
	 @Test
	 public void getOrderListTest() {
		 orderService.getOrderList("10.04.2022","11.04.2022");
				 
	 }
}
