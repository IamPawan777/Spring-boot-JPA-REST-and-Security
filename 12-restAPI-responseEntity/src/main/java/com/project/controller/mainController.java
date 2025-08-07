package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Entity.Books;
import com.project.Service.DemoService;

@RestController
public class mainController {
	
	@Autowired
	private DemoService bookService; 
	
	
	@GetMapping("/book")
	public ResponseEntity<List<Books>> showAllBooks() {			// return json formate
		List<Books> list =  bookService.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 return ResponseEntity.of(Optional.of(list));
	}	
	
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Books> showBookById(@PathVariable("id") int id) {
		Books book = bookService.getBookById(id);
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	
	
	@PostMapping("/book")
	public ResponseEntity<Books> addBook(@RequestBody Books b) {
		Books book = null;
		try{
			book = bookService.addBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}	
	
	
	
	@DeleteMapping("/book/{bid}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bid") int id) {
		try {
			bookService.deleteBookById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		// 204
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Books> updataBook(@RequestBody Books b, @PathVariable("id") int id) {
		try {
			bookService.updataBook(b, id);
			return ResponseEntity.ok().body(b);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
