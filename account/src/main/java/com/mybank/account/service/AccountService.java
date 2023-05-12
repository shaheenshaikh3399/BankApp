package com.mybank.account.service;


import com.mybank.account.dto.AccountDto;

public interface AccountService {
	
	public AccountDto CreateAccount(AccountDto accountDto);
	
	public AccountDto getAccountById(String accountNumber);

}
