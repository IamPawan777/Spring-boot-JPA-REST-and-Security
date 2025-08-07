package com.project.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DelivaryAddressRequest {
	private String dStreetName;
	private String dBuildingName;
	private String dFlatNo;
	private String dCity;
	private String dState;
	private int dPinCode;
}
