package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.OrderDTO;
import com.example.demo.model.OrderData;

public interface IOrderService {
	
	OrderData addOrder (OrderDTO orderDTO);
	
	List<OrderData> getOrderDetails();
	
	OrderData getOrderById(int id);
	
	void deleteOrderById(int id);

}
