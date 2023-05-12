package com.mybank.registrations.service;

import com.mybank.registrations.dto.LoginDto;
import com.mybank.registrations.dto.RegistrationDto;

public interface RegistrationService {
	//public RegistrationDto registerCustomer(RegistrationDto registrationDto);
	
	//public ApiResponseDto getRegistrationDetails(Long registrationId);
	
	public String verifyCustomerDetails(RegistrationDto registrationdto);
	
	// public char[] generateOTP(int length);

	
	public String registerCustomerwithOtp(RegistrationDto registrationDto, Long otp);
	
	public String CustomerSignIn(LoginDto loginDto);

}
