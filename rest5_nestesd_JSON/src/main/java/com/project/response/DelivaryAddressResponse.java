package com.project.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelivaryAddressResponse {
	private String dStreetName;
	private String dBuildingName;
	private String dFlatNo;
	private String dCity;
	private String dState;
	private int dPinCode;
}
