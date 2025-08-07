package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.project.dto.request.BookingRequest;
import com.project.dto.response.BookingResponse;
import com.project.entity.Booking;
import com.project.entity.Cab;
import com.project.entity.Customer;
import com.project.entity.Driver;
import com.project.repository.BookingRepository;
import com.project.repository.CabRepository;
import com.project.repository.CustomerRepository;
import com.project.repository.DriverRepository;
import com.project.service.exceptions.CabUnAvailableException;
import com.project.service.exceptions.CustomerNotFoundException;
import com.project.transformer.BookingTransformer;

@Service
public class BookingService {

	@Value("${spring.mail.username}") 
	private String sender;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CabRepository cabRepository;
	
	@Autowired
	DriverRepository driverRepository;

	@Autowired
	JavaMailSender javaMailSender;

	public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) {
		Optional<Customer> byId = customerRepository.findById(customerId);
		if(byId.isEmpty())
			throw new CustomerNotFoundException("Customer Not Found. Add This Customer First...");
		Customer customer = byId.get();
		
		
		Cab availableCabRandom = cabRepository.getAvailableCabRandom();
		if(availableCabRandom == null) 
			throw new CabUnAvailableException("Sorry No Cab Available");
		Booking requestToBooking = BookingTransformer.bookingRequestToBooking(bookingRequest, availableCabRandom.getCabPerKmRate());
		Booking saveBooking = bookingRepository.save(requestToBooking);
		availableCabRandom.setCabAvailable(false);
		
		
		customer.getBooking().add(saveBooking);
		Driver driver  = driverRepository.getDriverByCabId(availableCabRandom.getCab_id());
		driver.getBooking().add(saveBooking);
		
		Customer saveCustomer = customerRepository.save(customer);
		Driver saveDriver = driverRepository.save(driver);
		
		sendEmail(saveCustomer, availableCabRandom);
		
		return BookingTransformer.bookingToBookingResponse(saveBooking, saveCustomer, availableCabRandom, saveDriver);
	}
	
	
	
	private void sendEmail(Customer customer, Cab cab) {
		
		String msg = "Congrats!! "+customer.getName()+" Your Cab "+cab.getCabNumber()+" has been booked.";
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("springtester7@gmail.com");
		mailMessage.setTo(customer.getEmailId());
		mailMessage.setSubject("Cab Booked. Successfully!");
		mailMessage.setText(msg);
//		mailMessage.notify();
		
		javaMailSender.send(mailMessage);		
	}
}
