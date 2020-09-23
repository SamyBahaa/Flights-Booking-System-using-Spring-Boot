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

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return services.saveCustomer(customer);
    }

    @GetMapping("/searchFlight/{fare}/{fromPlace}/{toPlace}")
    public List<Flights> searchFlight(@PathVariable double fare,@PathVariable String fromPlace,@PathVariable String toPlace) {
        return services.searchFlight(fare,fromPlace,toPlace);
    }
}
