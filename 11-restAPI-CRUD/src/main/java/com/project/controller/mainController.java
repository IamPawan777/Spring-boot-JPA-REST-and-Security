package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/getMsg")
//	@ResponseBody
	public String showMsg() {
		return "This is third first API...";
	}
	
	
	@GetMapping("/book")
	public List<Books> showAllBooks() {			// return json formate
		return bookService.getAllBooks();
	}	
	@GetMapping("/book/{id}")
	public Books showBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	
	
	@PostMapping("/book")
	public Books addBook(@RequestBody Books b) {
		Books book = bookService.addBook(b);
		return book;
	}	
	
	
	
	@DeleteMapping("/book/{bid}")
	public void deleteBook(@PathVariable("bid") int id) {
		bookService.deleteBookById(id);
	}
	
	
	
	@PutMapping("/book/{id}")
	public Books updataBook(@RequestBody Books b, @PathVariable("id") int id) {
		bookService.updataBook(b, id);
		return b;
	}
}
