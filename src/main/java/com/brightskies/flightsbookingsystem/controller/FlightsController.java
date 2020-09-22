package com.brightskies.flightsbookingsystem.controller;

import com.brightskies.flightsbookingsystem.entity.Flights;
import com.brightskies.flightsbookingsystem.service.FlightsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightsController {

    @Autowired
    FlightsServices service;

    @PostMapping("/addFlight")
    public Flights addProduct(@RequestBody Flights flight) {
        return service.saveFlight(flight);
    }

    @PostMapping("/addFlights")
    public List<Flights> addProducts(@RequestBody List<Flights> flights) {
        return service.saveFlights(flights);
    }

    @GetMapping("/flights")
    public List<Flights> findAllFlights() {
        return service.getFlights();
    }

    @GetMapping("/flightById/{id}")
    public Flights findProductById(@PathVariable int id) {
        return service.getFlightById(id);
    }

    @PutMapping("/update")
    public Flights updateFlight(@RequestBody Flights flight) {
        return service.updateFlight(flight);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFlight(@PathVariable int id) {
        return service.deleteFlight(id);
    }
}
