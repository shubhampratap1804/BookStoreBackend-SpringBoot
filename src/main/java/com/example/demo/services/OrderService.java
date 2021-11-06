package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.OrderDTO;
import com.example.demo.exceptions.BookCustomException;
import com.example.demo.model.OrderData;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<OrderData> getOrderDetails() {
		return orderRepository.findAll();
	}
	
	@Override
	public OrderData addOrder(OrderDTO orderDTO) {
		OrderData orderData = null;
		orderData = new OrderData(orderDTO);
		return orderRepository.save(orderData);
	}

	@Override
	public void deleteOrderById(int id) {
		OrderData orderData = this.getOrderById(id);
		orderRepository.delete(orderData);
	}

	@Override
	public OrderData getOrderById(int id) {
		return orderRepository.findById(id).orElseThrow( () -> 
		new BookCustomException("Order with this id " + id + "doest not exists!"));
	}
}
