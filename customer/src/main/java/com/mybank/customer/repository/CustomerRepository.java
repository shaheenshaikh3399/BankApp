package com.mybank.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.customer.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{
	public Customer findByCustomerId(String customerId);

}
