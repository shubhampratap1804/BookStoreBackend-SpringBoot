package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.BookDTO;
import com.example.demo.exceptions.BookCustomException;
import com.example.demo.model.BookData;
import com.example.demo.repository.BookRepository;

@Service
public class BookService implements IBookService {

	@Autowired
	BookRepository bookRepository;
	
	
	@Override
	public List<BookData> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public BookData addBook(BookDTO bookDTO) {
		BookData bookData = null;
		bookData = new BookData(bookDTO);
		System.out.println(bookDTO);
		return bookRepository.save(bookData); 
	}

	@Override
	public BookData updateBook(int id, BookDTO bookDTO) {
		BookData bookData = this.getBookByID(id);
		bookData.updateBookData(bookDTO);
		return bookRepository.save(bookData);
	}


	@Override
	public void deleteBook(int id) {
		BookData bookData = this.getBookByID(id);
		bookRepository.delete(bookData);
	}


	@Override
	public BookData getBookByID(int id) {
		return bookRepository.findById(id).orElseThrow( () -> 
		new BookCustomException("Book with this id " + id + "doest not exists!"));
	}
}
