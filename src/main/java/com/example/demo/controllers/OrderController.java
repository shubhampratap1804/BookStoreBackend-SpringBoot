package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.OrderDTO;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.model.OrderData;
import com.example.demo.services.IOrderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	IOrderService iOrderService;

	@GetMapping("/getAllOrder") @CrossOrigin
	public ResponseEntity<ResponseDTO> getOrderDetails() {
		List<OrderData> orderList = null;
		orderList = iOrderService.getOrderDetails();
		ResponseDTO responseDTO = new ResponseDTO("Showing all order details!", orderList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@PostMapping("/addOrder")
	public ResponseEntity<ResponseDTO> addOrder(@RequestBody OrderDTO orderDTO){
		OrderData orderData = iOrderService.addOrder(orderDTO);
		ResponseDTO responseDTO = new ResponseDTO("Added order successful!", orderData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteOrder/{id}") @CrossOrigin
    public ResponseEntity<ResponseDTO> deleteExtraOrder(@PathVariable("id") int id){
    	iOrderService.deleteOrderById(id);
    	ResponseDTO responseDTO = new ResponseDTO("Deleted order successfully!", "Deleted for id: " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
