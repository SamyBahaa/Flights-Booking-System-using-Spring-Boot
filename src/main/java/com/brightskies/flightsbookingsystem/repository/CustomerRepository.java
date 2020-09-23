package com.brightskies.flightsbookingsystem.repository;

import com.brightskies.flightsbookingsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
