package com.example.demo.services;

import java.util.List;

import com.example.demo.DTO.CartDTO;
import com.example.demo.model.CartData;

public interface ICartService {

	CartData addToCart(CartDTO cartDTO);

	List<CartData> getCart();

	CartData getCartById(int id);

	void deleteCartById(int id);
}
