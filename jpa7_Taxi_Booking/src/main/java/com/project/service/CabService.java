package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.request.CabRequest;
import com.project.dto.response.CabResponse;
import com.project.entity.Cab;
import com.project.entity.Driver;
import com.project.repository.CabRepository;
import com.project.repository.DriverRepository;
import com.project.service.exceptions.DriverNotFoundException;
import com.project.transformer.CabTransformer;

@Service
public class CabService {
	
	@Autowired
	CabRepository cabRepository;

	@Autowired
	DriverRepository driverRepository;

	public CabResponse registerCab(CabRequest cabRequest, int driverId) {
		Optional<Driver> byId = driverRepository.findById(driverId);		// Option return: present and not present
		// 1. not present
		if(byId.isEmpty())
			throw new DriverNotFoundException("Invalid Driver ID.. This Driver Id not present.");		
		// 2. present
		Driver driver = byId.get();
		
		Cab cab = CabTransformer.cabRequestToCab(cabRequest);
		driver.setCab(cab);													// driver class need
		
//		Cab saveCab = cabRepository.save(cab);
		Driver saveDriver = driverRepository.save(driver);					// save both "driver" and "cab" bcz of CaseCade.ALL
		
		return CabTransformer.cabToCabResponse(saveDriver.getCab(), saveDriver);
		
		
	}
}
