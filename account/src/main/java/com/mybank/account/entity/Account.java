package com.mybank.account.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.mybank.account.dto.AccountType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false, length = 10, name = "account_number")
	private String number;
	
	@Column(nullable = false, length = 50, name = "account_type")
	
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	@Column(nullable = false)
	private Float balance;
	
	private String customerId;
	
	@Column(name = "opening_date")
	@CreationTimestamp
	private LocalDateTime openingDate;
	

}
