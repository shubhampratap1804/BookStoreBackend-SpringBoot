package com.example.demo.controllers;

import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.model.BookData;

import com.example.demo.services.IBookService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/book") 
public class BookController {
	
	@Autowired
	IBookService bookService;

    @GetMapping("/getAllBook") @CrossOrigin
    public ResponseEntity<ResponseDTO> getBookDetails() {
    	List<BookData> bookList = null;
        bookList = bookService.getAllBooks();
        ResponseDTO responseDTO = new ResponseDTO("Showing all book details!", bookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    
    @GetMapping("/getBook/{id}") @CrossOrigin
    public ResponseEntity<ResponseDTO> getBookById(@PathVariable("id") int id){
		BookData bookData = bookService.getBookByID(id);
		ResponseDTO responseDTO = new ResponseDTO("Get call for Id is successful!", bookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public ResponseEntity<ResponseDTO> addExtraBooks(@RequestBody BookDTO bookDTO){
    	System.out.println(bookDTO);
    	BookData bookData = bookService.addBook(bookDTO);
    	ResponseDTO responseDTO = new ResponseDTO("Added Book successfully!", bookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    
    @PutMapping("/updateBook/{id}") @CrossOrigin
    public ResponseEntity<ResponseDTO> updateExtraBooks(@PathVariable("id") int id, @RequestBody BookDTO bookDTO){
		BookData bookData = bookService.updateBook(id, bookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Book successfully!", bookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteBook/{id}") @CrossOrigin
    public ResponseEntity<ResponseDTO> deleteExtraBooks(@PathVariable("id") int id){
    	bookService.deleteBook(id);
    	ResponseDTO responseDTO = new ResponseDTO("Deleted Book successfully!", "Deleted for id: " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
 }
