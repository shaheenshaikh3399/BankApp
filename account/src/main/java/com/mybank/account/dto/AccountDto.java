package com.mybank.account.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {
	
	private Integer id;

	@NotBlank(message = "Account number cannot be empty")
	private String number;
	
	@NotNull(message = "Account type cannot be empty")
	private AccountType type;
	
	private Float balance;
	
	private String customerId;
	private LocalDateTime openingDate;

}
