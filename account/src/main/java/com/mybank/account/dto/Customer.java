package com.mybank.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String username;
	private Long otp;
}
