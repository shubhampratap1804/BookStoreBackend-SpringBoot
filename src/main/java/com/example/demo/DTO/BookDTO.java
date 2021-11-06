package com.example.demo.DTO;

import lombok.Data;

@Data
public class BookDTO {

    public String bookName;
    public String authorName;
    public String bookImage;
    public int bookQuantity;
    public int bookPrice;
    public String bookDescription;
    
    
	public BookDTO(String bookName, String authorName, String bookImage, int bookQuantity, int bookPrice, String bookDescription) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookImage = bookImage;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
		this.bookDescription = bookDescription;
	}
}
