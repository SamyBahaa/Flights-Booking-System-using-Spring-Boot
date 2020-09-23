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

    /**
     * @param flight
     * Add flight to database
     * @return the flight object as json object.
     */
    @PostMapping("/addFlight")
    public Flights addFlight(@RequestBody Flights flight) {
        return service.saveFlight(flight);
    }

    /**
     * @param flights
     * Add flights to the database at once
     * @return the flights object as json array.
     */
    @PostMapping("/addFlights")
    public List<Flights> addFlights(@RequestBody List<Flights> flights) {
        return service.saveFlights(flights);
    }

    /**
     * @return all the flights as json array.
     */
    @GetMapping("/flights")
    public List<Flights> findAllFlights() {
        return service.getFlights();
    }

    /**
     * @param id of the flight
     * @return the specific flight object as json.
     */
    @GetMapping("/flightById/{id}")
    public Flights findFlightById(@PathVariable int id) {
        return service.getFlightById(id);
    }

    /**
     * @param flight
     * Update the information of specific flight
     * @return the flight object as json.
     */
    @PutMapping("/update")
    public Flights updateFlight(@RequestBody Flights flight) {
        return service.updateFlight(flight);
    }

    /**
     * @param id of the flight
     * @return a successful message of deleting
     */
    @DeleteMapping("/delete/{id}")
    public String deleteFlight(@PathVariable int id) {
        return service.deleteFlight(id);
    }
}
