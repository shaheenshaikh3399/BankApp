package com.mybank.registrations.mapper;

import com.mybank.registrations.dto.RegistrationDto;
import com.mybank.registrations.entity.Registration;

public class RegistrationMapper {
	
	public static RegistrationDto mapToRegistrationDto(Registration registration){
		
		RegistrationDto registrationDto = new RegistrationDto(
				registration.getId(),
				registration.getFirstName(),
				registration.getLastName(),
				registration.getEmail(),	
				registration.getCustomerId(),
				registration.getUsername(),
				registration.getPassword());
		return registrationDto;
	}
	
	
	public static Registration mapToregistration(RegistrationDto registrationDto) {
		Registration registration = new Registration(
				registrationDto.getId(),
				registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getEmail(),
				registrationDto.getCustomerId(),
				registrationDto.getUsername(),
				registrationDto.getPassword());
		
		return registration;
		
	}


}
