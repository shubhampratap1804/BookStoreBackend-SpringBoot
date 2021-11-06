package com.example.demo.DTO;

import lombok.Data;

@Data
public class CartDTO {

    public String bookName;
    public String authorName;
    public String image;
    public int quantity;
    public int price;
    public String bookDescription;
    
    
	public CartDTO(String bookName, String authorName, String image, int quantity, int price, String bookDescription) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
		this.bookDescription = bookDescription;
	}
}
