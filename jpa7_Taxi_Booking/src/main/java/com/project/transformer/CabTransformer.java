package com.project.transformer;

import com.project.dto.request.CabRequest;
import com.project.dto.response.CabResponse;
import com.project.entity.Cab;
import com.project.entity.Driver;

public class CabTransformer {

	public static Cab cabRequestToCab(CabRequest cabRequest) {
		return Cab.builder()
				.cabNumber(cabRequest.getCabNumber())
				.cabModel(cabRequest.getCabModel())
				.cabPerKmRate(cabRequest.getCabPerKmRate())
				.cabAvailable(true)
				.build();
	}

	public static CabResponse cabToCabResponse(Cab cab, Driver driver) {
		return CabResponse.builder()
				.cabNumber(cab.getCabNumber())
				.cabModel(cab.getCabModel())
				.cabPerKmRate(cab.getCabPerKmRate())
				.cabAvailable(cab.isCabAvailable())				// boolean
				.cabDriverResponse(DriverTransformer.driverToDriverResponse(driver))
				.build();
	}

}
