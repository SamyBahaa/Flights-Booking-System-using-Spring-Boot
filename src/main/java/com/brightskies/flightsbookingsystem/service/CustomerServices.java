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

    /**
     * @param customer
     * Add a customer to the database
     * @return
     */
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    /**
     * @param fare
     * @param fromPlace
     * @param toPlace
     * search for a flight depend on the price and from, to specific location that customer choose
     * @return the available flights that match the requirement
     */
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

    /**
     * @param flightId
     * @param customerId
     * book a flight and add it to the customer flightsList
     * @return a successful message of booking
     */
    public String bookFlight(int flightId,int customerId){
        Flights existingFlight = flightsrepository.findById(flightId).orElse(null);
        Customer existingCustomer = repository.findById(customerId).orElse(null);
        existingCustomer.getFlightslist().add(existingFlight);
        repository.save(existingCustomer);
        return "Flight who's id = " + flightId + ", has been booked successfully !! ";
    }

    /**
     * @param flightId
     * @param customerId
     * cancel a flight and remove it to the customer flightsList
     * @return a successful message of canceling
     */
    public String cancelFlight(int flightId,int customerId){
        Flights existingFlight = flightsrepository.findById(flightId).orElse(null);
        Customer existingCustomer = repository.findById(customerId).orElse(null);
        existingCustomer.getFlightslist().remove(existingFlight);
        repository.save(existingCustomer);
        return "Flight who's id = " + flightId + ", has been canceled successfully !! ";
    }

    /**
     * @param flightId
     * @param Class class type (First,Second,Economy or Business)
     * upgrade the class of the flight
     * @return a successful message of upgrading
     */
    public String upgradeFlight(int flightId,String Class){
        Flights existingFlight = flightsrepository.findById(flightId).orElse(null);
        existingFlight.setTicketClass(Class);
        flightsrepository.save(existingFlight);
        return "Flight who's id = " + flightId + ", has been upgraded successfully !! ";
    }
}