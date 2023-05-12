package com.mybank.registrations.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	private String customerId;
	private String username;
	private String password;

}
