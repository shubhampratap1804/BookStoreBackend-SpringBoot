package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.DTO.BookDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "book_data")
public class BookData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int bookId;
	private String bookName;
	private String authorName;
	private String bookImage;
	private int bookQuantity;
	private int bookPrice;
	private String bookDescription;
	
	
	public BookData() { }
	
	public BookData(BookDTO bookDTO) {
		this.updateBookData(bookDTO);
	}
	
	public void updateBookData(BookDTO bookDTO) {
		this.bookName = bookDTO.bookName;
		this.authorName = bookDTO.authorName;
		this.bookImage = bookDTO.bookImage;
		this.bookQuantity = bookDTO.bookQuantity;
		this.bookPrice = bookDTO.bookPrice;
		this.bookDescription = bookDTO.bookDescription;
	}
}
