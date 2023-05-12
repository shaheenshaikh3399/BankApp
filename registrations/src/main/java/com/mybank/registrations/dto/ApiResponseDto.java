package com.mybank.registrations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApiResponseDto {
	
	private RegistrationDto registrationDto;
	private Customer customer;

}
