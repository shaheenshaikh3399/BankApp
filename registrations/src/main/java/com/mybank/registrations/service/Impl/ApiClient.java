package com.mybank.registrations.service.Impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mybank.registrations.dto.Customer;

@FeignClient(name="CUSTOMER")
public interface ApiClient {
	@GetMapping("api/customer/{customerId}")
	Customer getCustomer(@PathVariable("customerId") String customerId);

}
