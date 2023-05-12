package com.mybank.customer.controller;

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

import com.mybank.customer.entity.Customer;
import com.mybank.customer.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/customer")
public class CustomerController {
	private  static final Logger LOGGER=  LoggerFactory.getLogger(CustomerController.class);

	
	private CustomerService customerService;
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}
	@GetMapping("{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String customerId){
		return new ResponseEntity<Customer>(customerService.findByCustomerId(customerId), HttpStatus.FOUND);
	}
	@GetMapping("/otp/{customerId}")
		public String getOtp (@PathVariable String customerId) {
			return "Your OTP is "+customerService.getOtp(customerId);
		}
	


}
