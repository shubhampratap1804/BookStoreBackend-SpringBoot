package com.example.demo.DTO;

import lombok.Data;

@Data
public class OrderDTO {

	public int numberOfBooksOrdered;
	public int totalPrice;

	public OrderDTO(int orderId, int numberOfBooksOrdered, int totalPrice) {
		this.numberOfBooksOrdered = numberOfBooksOrdered;
		this.totalPrice = totalPrice;
	}
}
