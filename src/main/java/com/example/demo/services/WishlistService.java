package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DTO.WishlistDTO;
import com.example.demo.model.WishlistData;
import com.example.demo.repository.WishlistRepository;

public class WishlistService implements IWishlistServices {
	
	@Autowired
	WishlistRepository wishlistRepository;

	@Override
	public WishlistData addToWishlist(WishlistDTO wishlistDTO) {
		
		return null;
	}

	@Override
	public List<WishlistData> getWishlist() {
		return wishlistRepository.findAll();
	}

	@Override
	public void deleteWishlist(int id) {
		
		
	}

}
