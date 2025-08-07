package com.project.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 1)
@Component
public class Notification implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("WhatsApp notification....");
		
	}
	
}
