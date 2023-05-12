package com.mybank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	public Account findByNumber(String number);

}
