package com.mybank.account.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.account.dto.AccountDto;
import com.mybank.account.service.AccountService;

import lombok.AllArgsConstructor;
@Validated

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {
	
	private AccountService accountService;
	
	private  static final Logger LOGGER=  LoggerFactory.getLogger(AccountController.class);

	
	@PostMapping(value = "/add")
	public AccountDto createAccount(@Valid @RequestBody AccountDto accountDto) {
		LOGGER.info("New account created with account object: {}",accountDto);
		return accountService.CreateAccount(accountDto);
	}
	
	@GetMapping("{number}")
	public ResponseEntity<AccountDto> getAccountDetailsById(@PathVariable String number){
		return new ResponseEntity<AccountDto> (accountService.getAccountById(number), HttpStatus.FOUND);
		
	}

}
