package com.mybank.registrations.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="First Name can not be empty")
	private String firstName;
	@NotBlank(message="Last Name can not be empty")
	private String lastName;
	@Email(regexp="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	private String customerId;
	private String username;
	private String password;


}
