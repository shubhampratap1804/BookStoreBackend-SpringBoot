package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.WishlistDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "wishList_data")

public class WishlistData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private String bookDetails;
	private String authorName;
	private String bookName;
	private int price;
	private int noOfBooks;
	private String image;

	public WishlistData() {
	}

	public WishlistData(WishlistDTO wishlistDTO) {
		this.updateWishlistData(wishlistDTO);
	}

	public void updateWishlistData(WishlistDTO wishlistDTO) {
		this.bookDetails = wishlistDTO.bookDetails;
		this.authorName = wishlistDTO.authorName;
		this.bookName = wishlistDTO.bookName;
		this.price = wishlistDTO.price;
		this.noOfBooks = wishlistDTO.noOfBooks;
		this.image = wishlistDTO.image;

	}
}
