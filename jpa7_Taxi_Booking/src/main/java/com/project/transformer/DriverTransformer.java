package com.project.transformer;

import com.project.dto.request.DriverRequest;
import com.project.dto.response.DriverResponse;
import com.project.entity.Driver;

public class DriverTransformer {

	public static Driver driverRequestToDriver(DriverRequest driverRequest) {
		return Driver.builder()
				.name(driverRequest.getName())
				.age(driverRequest.getAge())
				.emailId(driverRequest.getEmailId())
				.build();
	}

	public static DriverResponse driverToDriverResponse(Driver save) {
		return DriverResponse.builder()
				.driver_id(save.getDriver_id())
				.name(save.getName())
				.age(save.getAge())
				.emailId(save.getEmailId())
				.build();
	}
	
}
