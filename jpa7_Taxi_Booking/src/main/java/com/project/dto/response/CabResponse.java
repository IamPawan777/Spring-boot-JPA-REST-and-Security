package com.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CabResponse {
	private String cabNumber;
	private String cabModel;
	private double cabPerKmRate;
	private boolean cabAvailable;
	
	private DriverResponse cabDriverResponse;
}
