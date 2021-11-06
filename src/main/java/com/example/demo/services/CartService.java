package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CartDTO;
import com.example.demo.exceptions.BookCustomException;
import com.example.demo.model.CartData;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.UserRepository;

@Service
public class CartService implements ICartService {
	
	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CartRepository cartRepository;

	@Override
	public List<CartData> getCart() {
		return cartRepository.findAll();
	}

	@Override
	public CartData addToCart(CartDTO cartDTO) {
		CartData cartData = null;
		cartData = new CartData(cartDTO);
		return cartRepository.save(cartData);
	}
	
	@Override
	public void deleteCartById(int id) {
		CartData cardData = this.getCartById(id);
		cartRepository.delete(cardData);
	}

	@Override
	public CartData getCartById(int id) {
		return cartRepository.findById(id).orElseThrow( () -> 
		new BookCustomException("Book with this id " + id + "doest not exists!"));
	}
}
