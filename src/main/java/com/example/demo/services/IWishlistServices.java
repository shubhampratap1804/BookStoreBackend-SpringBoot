package com.example.demo.services;

import java.util.List;
import com.example.demo.DTO.WishlistDTO;
import com.example.demo.model.WishlistData;

public interface IWishlistServices {

	WishlistData addToWishlist(WishlistDTO wishlistDTO);

	List<WishlistData> getWishlist();

	void deleteWishlist(int id);

}
