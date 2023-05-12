package com.mybank.customer.service;

import org.springframework.stereotype.Service;

import com.mybank.customer.entity.Customer;
import com.mybank.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CustomerService {

	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer findByCustomerId(String customerId) {
		return customerRepository.findByCustomerId(customerId);
	}
	
	public Long getOtp(String customerId) {
		Long otp = customerRepository.findByCustomerId(customerId).getOtp();
		return otp;
	}
	
}
