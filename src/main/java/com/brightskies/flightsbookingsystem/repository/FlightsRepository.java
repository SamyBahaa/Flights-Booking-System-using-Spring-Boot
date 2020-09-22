package com.brightskies.flightsbookingsystem.repository;

import com.brightskies.flightsbookingsystem.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightsRepository extends JpaRepository<Flights,Integer> {
}
