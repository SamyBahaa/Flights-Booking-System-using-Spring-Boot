package com.brightskies.flightsbookingsystem.service;

import com.brightskies.flightsbookingsystem.entity.Flights;
import com.brightskies.flightsbookingsystem.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsServices {

    @Autowired
    private FlightsRepository repository;

    public Flights saveFlight(Flights flight) {
        return repository.save(flight);
    }

    public List<Flights> saveFlights(List<Flights> flights) {
        return repository.saveAll(flights);
    }

    public List<Flights> getFlights() {
        return repository.findAll();
    }

    public Flights getFlightById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteFlight(int id) {
        repository.deleteById(id);
        return "Flight who's id =" + id + ", has been removed successfully !! ";
    }

    public Flights updateFlight(Flights flight) {
        Flights existingFlight = repository.findById(flight.getId()).orElse(null);
        existingFlight.setArrival(flight.getArrival());
        existingFlight.setDeparture(flight.getDeparture());
        existingFlight.setFare(flight.getFare());
        existingFlight.setFromPlace(flight.getFromPlace());
        existingFlight.setToPlace(flight.getToPlace());
        existingFlight.setTicketClass(flight.getTicketClass());
        existingFlight.setAvailable(flight.isAvailable());
        return repository.save(existingFlight);
    }
}
