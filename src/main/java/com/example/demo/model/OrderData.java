package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.DTO.OrderDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "order_details")
public class OrderData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private int numberOfBooksOrdered;
	private int totalPrice;

	public OrderData() {
	}

	public OrderData(OrderDTO orderDTO) {
		this.numberOfBooksOrdered = orderDTO.numberOfBooksOrdered;
		this.totalPrice = orderDTO.totalPrice;
	}
}