package com.example.demo.DTO;

import lombok.Data;

@Data
public class WishlistDTO {
	
	public String bookDetails;
	public String authorName;
	public String bookName;
	public int price;
	public int noOfBooks;
	public String image;

	public WishlistDTO(int bookId, String bookDetails, String authorName, String bookName, int price, int noOfBooks,
			String image) {
		
		this.bookDetails = bookDetails;
		this.authorName = authorName;
		this.bookName = bookName;
		this.price = price;
		this.noOfBooks = noOfBooks;
		this.image = image;
	}
}
