package com.rig.ReadingIsGoodApp.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rig.ReadingIsGoodApp.helper.OrderStatus;

import lombok.Data;

@Data
@Document
public class Order {
	@Id
    private String id;
    private String customerId;
	private BigDecimal totalPrice;
    private Date createDate;
    private Date lastUpdateDate;
    private OrderStatus status;
    private List<OrderDetail> orderDetail;
    
	public Order(String customerId, BigDecimal totalPrice, Date createDate, Date lastUpdateDate, List<OrderDetail> orderDetail) {
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.createDate = createDate;
		this.lastUpdateDate = lastUpdateDate;
		this.status = OrderStatus.IN_PROGRESS;
		this.orderDetail = orderDetail;
	}
}
