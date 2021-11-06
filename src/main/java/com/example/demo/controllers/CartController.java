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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.CartDTO;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.model.CartData;
import com.example.demo.services.ICartService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	ICartService cartService;

	@GetMapping(value = "/getCartDetails")@CrossOrigin
	public ResponseEntity<ResponseDTO> getCartDetails() {
		List<CartData> cartList = null;
		cartList = cartService.getCart();
		ResponseDTO responseDTO = new ResponseDTO("Fetched all cart details", cartList);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/addToCart")
	public ResponseEntity<ResponseDTO> addCartDetails(@RequestBody CartDTO cardDTO) {
		CartData cartData = cartService.addToCart(cardDTO);
		ResponseDTO responseDTO = new ResponseDTO("Added to cart successfully", cartData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

	}

	@DeleteMapping("/deleteCartDetails/{id}") @CrossOrigin
	public ResponseEntity<ResponseDTO> deleteCartDetails(@PathVariable int id){
		cartService.deleteCartById(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted cart id : Cart Details", id);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
