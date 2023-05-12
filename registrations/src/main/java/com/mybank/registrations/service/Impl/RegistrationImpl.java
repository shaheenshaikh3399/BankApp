package com.mybank.registrations.service.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mybank.registrations.dto.Customer;
import com.mybank.registrations.dto.LoginDto;
import com.mybank.registrations.dto.RegistrationDto;
import com.mybank.registrations.entity.Registration;
import com.mybank.registrations.mapper.RegistrationMapper;
import com.mybank.registrations.repository.RegistrationRepository;
import com.mybank.registrations.service.RegistrationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationImpl  implements RegistrationService{
	private  static final Logger LOGGER=  LoggerFactory.getLogger(RegistrationImpl.class);

	//private ApiClient apiClient;
	private WebClient webClient;
	
	private RegistrationRepository registrationRepository;

	
	
	public String verifyCustomerDetails(RegistrationDto registrationdto) {
		
		Customer customer =
				  webClient.get().uri("http://localhost:9071/api/customer/"+registrationdto.
						  getCustomerId()) .retrieve() .bodyToMono(Customer.class) .block();
	
		if(customer!=null&& registrationdto.getCustomerId().equalsIgnoreCase(customer.getCustomerId())&& 
				registrationdto.getFirstName().equalsIgnoreCase(customer.getFirstName())&&
				registrationdto.getLastName().equalsIgnoreCase(customer.getLastName())&&
				registrationdto.getUsername().equalsIgnoreCase(customer.getUsername())&&
				registrationdto.getPassword().equalsIgnoreCase(customer.getPassword())) {
			
			return "Customer details are valid! Please enter OTP for registration.";
	}
		else {
			return "Details are not matched! Please try with the correct credentials.";
		}
		
	}
	
	  
	
	public String registerCustomerwithOtp(RegistrationDto registrationDto, Long otp) {
		
		Customer customer =
				  webClient.get().uri("http://localhost:9071/api/customer/"+registrationDto.
						  getCustomerId()) .retrieve() .bodyToMono(Customer.class) .block();
		 Long customerOtp = customer.getOtp();
	
		if(otp.equals(customer.getOtp())) {
			Registration registration = RegistrationMapper.mapToregistration(registrationDto);
			registrationRepository.save(registration);
			return "Customer has been registered successfully!!";
			
		}
		else {
			return "Please verify the OTP";
		}
		
	}
	
	
	public String CustomerSignIn(LoginDto loginDto) {
		LOGGER.info("Inside CustomerSignIn ");
		Customer customer =
				  webClient.get().uri("http://localhost:9071/api/customer/"+loginDto.
						  getCustomerId()) .retrieve() .bodyToMono(Customer.class) .block();
		LOGGER.info("Cusotmer details are "+customer);
		if(loginDto.getUsername().equalsIgnoreCase(customer.getUsername())
				&&loginDto.getPassword().equalsIgnoreCase(customer.getPassword())
				&&loginDto.getCustomerId().equalsIgnoreCase(customer.getCustomerId())) {
			return "Your credentials has been verified!";
		}
		else {
			return "Incorrect verify username or password";
		}
			
		
		
	}
	  
	 
}
