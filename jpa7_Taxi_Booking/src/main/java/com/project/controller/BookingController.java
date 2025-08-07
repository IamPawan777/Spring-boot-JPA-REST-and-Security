package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.request.BookingRequest;
import com.project.dto.response.BookingResponse;
import com.project.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/book/customer/{customerId}")
	public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest, @PathVariable("customerId") int customerId) {
		return bookingService.bookCab(bookingRequest, customerId);
	}

}
