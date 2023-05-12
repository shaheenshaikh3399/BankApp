package com.mybank.registrations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.registrations.entity.Registration;

public interface RegistrationRepository  extends JpaRepository<Registration, Long> {

}
