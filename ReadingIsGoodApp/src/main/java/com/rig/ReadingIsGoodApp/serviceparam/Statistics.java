package com.rig.ReadingIsGoodApp.serviceparam;

import lombok.Data;

@Data
public class Statistics {
	private int month;
    private int totalOrderCount;
    private int totalCountOfPurchasedBooks;
    private double totalAmountOfAllOrders;
}
