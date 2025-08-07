package com.project.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.project.dto.NetBankingInfoDTO;

@Service
public class UserPaymentService {

	public List<String> getPaymentOption() {
		System.out.println("In service layer  : consumer aaplication: getting data from producer application");

		
		// call Rest service of producer app.n
		
		String url =  "http://localhost:8080/Producer/payment/options";
		
		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
		ResponseEntity<List> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, List.class);
		
		List<String> paymentOption = responseEntity.getBody();
		System.out.println(responseEntity.getStatusCode().value());
		
		return paymentOption;		
	}

	
	// calling POST with body
	public String doNetBanking() {
		NetBankingInfoDTO netBankingInfoDTO  = new NetBankingInfoDTO();
		netBankingInfoDTO.setUsername("Pawan");
		netBankingInfoDTO.setPassword("1212");
		netBankingInfoDTO.setAmountToBePaid(77);		
		HttpEntity<NetBankingInfoDTO> httpEntity = new HttpEntity<NetBankingInfoDTO>(netBankingInfoDTO);
		
		String url = "http://localhost:8080/Producer/payment/netbanking";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		
		String responseBody = responseEntity.getBody();
		return responseBody;
	}
	
	
	
	
	
	
	

}

