package com.brightskies.flightsbookingsystem.service;

import com.brightskies.flightsbookingsystem.entity.Customer;
import com.brightskies.flightsbookingsystem.entity.Flights;
import com.brightskies.flightsbookingsystem.repository.CustomerRepository;
import com.brightskies.flightsbookingsystem.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    public FlightsRepository flightsrepository;

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Flights> searchFlight(double fare, String fromPlace, String toPlace){
        List<Flights> allFlights= flightsrepository.findAll();
        List<Flights> availableFlights = new ArrayList<>();
        for (Flights flight :allFlights
             ) {
            if(flight.isAvailable() && flight.getFare()<= fare && flight.getFromPlace().toLowerCase().equals(fromPlace.toLowerCase()) && flight.getToPlace().toLowerCase().equals(toPlace.toLowerCase())){
                availableFlights.add(flight);
            }
        }
        return availableFlights;
    }
    
}