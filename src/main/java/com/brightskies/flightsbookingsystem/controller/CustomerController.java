package com.brightskies.flightsbookingsystem.controller;

import com.brightskies.flightsbookingsystem.entity.Customer;
import com.brightskies.flightsbookingsystem.entity.Flights;
import com.brightskies.flightsbookingsystem.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerServices services;

    /**
     * @param customer
     * add customer to the database
     * @return the customer object as json object.
     */
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return services.saveCustomer(customer);
    }

    /**
     * @param fare
     * @param fromPlace
     * @param toPlace
     * search for a flight depend on the price and from, to specific location that customer choose
     * @return the available flights that match the requirement
     */
    @GetMapping("/searchFlight/{fare}/{fromPlace}/{toPlace}")
    public List<Flights> searchFlight(@PathVariable double fare,@PathVariable String fromPlace,@PathVariable String toPlace) {
        return services.searchFlight(fare,fromPlace,toPlace);
    }

    /**
     * @param flightId
     * @param customerId
     * book a flight and add it to the customer flightsList
     * @return a successful message of booking
     */
    @PutMapping("/bookFlight/{flightId}/{customerId}")
    public String bookFlight(@PathVariable int flightId,@PathVariable int customerId) {
        return services.bookFlight(flightId,customerId);
    }

    /**
     * @param flightId
     * @param customerId
     * cancel a flight and remove it to the customer flightsList
     * @return a successful message of canceling
     */
    @PutMapping("/cancelFlight/{flightId}/{customerId}")
    public String cancelFlight(@PathVariable int flightId,@PathVariable int customerId) {
        return services.cancelFlight(flightId,customerId);
    }

    /**
     * @param flightId
     * @param Class class type (First,Second,Economy or Business)
     * upgrade the class of the flight
     * @return a successful message of upgrading
     */
    @PutMapping("/upgradeFlight/{flightId}/{Class}")
    public String upgradeFlight(@PathVariable int flightId,@PathVariable String Class) {
        return services.upgradeFlight(flightId,Class);
    }
}
