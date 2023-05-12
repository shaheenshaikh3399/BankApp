package com.mybank.account.mapper;

import com.mybank.account.dto.AccountDto;
import com.mybank.account.entity.Account;

public class AccountMapper {
	
	public static AccountDto mapToAccountDto(Account account) {
		
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getNumber(),
				account.getType(),
				account.getBalance(),
				account.getCustomerId(),
				account.getOpeningDate());
		return accountDto;
		
	}
public static Account mapToAccount(AccountDto accountDto) {
	Account account = new Account(
			accountDto.getId(),
			accountDto.getNumber(),
			accountDto.getType(),
			accountDto.getBalance(),
			accountDto.getCustomerId(),
			accountDto.getOpeningDate());
	return account;
		
	}

}
