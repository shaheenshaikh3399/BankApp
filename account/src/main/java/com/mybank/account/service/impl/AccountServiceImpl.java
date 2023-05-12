package com.mybank.account.service.impl;

import org.springframework.stereotype.Service;

import com.mybank.account.dto.AccountDto;
import com.mybank.account.entity.Account;
import com.mybank.account.mapper.AccountMapper;
import com.mybank.account.repository.AccountRepository;
import com.mybank.account.service.AccountService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;
	
	
	public AccountDto CreateAccount(AccountDto accountDto) {
		Account account=  AccountMapper.mapToAccount(accountDto);
         Account savedAccount = accountRepository.save(account);
         return AccountMapper.mapToAccountDto(savedAccount);
		
	}


	@Override
	public AccountDto getAccountById(String accountNumber) {
		Account account = new Account();
		try {
		 account = accountRepository.findByNumber(accountNumber);
		return AccountMapper.mapToAccountDto(account);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return AccountMapper.mapToAccountDto(account);
	}
	

}
