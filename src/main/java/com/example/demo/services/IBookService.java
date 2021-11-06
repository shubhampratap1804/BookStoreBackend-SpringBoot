package com.example.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DTO.BookDTO;
import com.example.demo.model.BookData;


public interface IBookService {
	
	 List<BookData> getAllBooks();
	 
	 BookData addBook(BookDTO bookDTO);
	 
	 BookData updateBook(int id, BookDTO bookDTO);
	    
	 BookData getBookByID(int id);
	 
	 void deleteBook(int id);
	 
}
