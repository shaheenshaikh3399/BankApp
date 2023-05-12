package com.mybank.registrations.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.registrations.dto.LoginDto;
import com.mybank.registrations.dto.RegistrationDto;
import com.mybank.registrations.service.RegistrationService;
import com.mybank.registrations.service.Impl.RegistrationImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/customer")
@AllArgsConstructor
public class RegistrationController {
	private  static final Logger LOGGER=  LoggerFactory.getLogger(RegistrationController.class);

	private RegistrationService registrationService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String>  verifyDetailsOfCustomer(@RequestBody RegistrationDto registrationDto) {
		return new ResponseEntity<String>(registrationService.verifyCustomerDetails(registrationDto), HttpStatus.ACCEPTED);
	}
	
	
   @PostMapping("{otp}")
   public ResponseEntity<String> registerCustomerWithOtp(@RequestBody RegistrationDto registrationDto ,@PathVariable Long otp){
	   String message= registrationService.registerCustomerwithOtp(registrationDto, otp);
	   return new ResponseEntity<String>( message, HttpStatus.ACCEPTED);
	   
   }
   @PostMapping("/login")
   public ResponseEntity<String> CustomerSignIn( @RequestBody LoginDto loginDto){
	   LOGGER.info("Inside LOGIN method");
	   String message= registrationService.CustomerSignIn(loginDto);
	   return new ResponseEntity<String>(message, HttpStatus.FOUND);
	   
   }
	
	

}
