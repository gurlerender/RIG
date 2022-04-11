package com.rig.ReadingIsGoodApp.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Book {
	@Id
    private String id;
    private String title;
    private String author;
    private BigDecimal price;
    private String currency;
    private int stock;
    
	public Book(String title, String author, BigDecimal price, String currency, int stock) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
		this.currency = currency;
	}
}
