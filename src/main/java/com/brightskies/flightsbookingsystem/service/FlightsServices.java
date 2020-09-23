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

    /**
     * @param flight
     * Add flight to database
     * @return the flight object as json object.
     */
    public Flights saveFlight(Flights flight) {
        return repository.save(flight);
    }

    /**
     * @param flights
     * Add flights to the database at once
     * @return the flights object as json array.
     */
    public List<Flights> saveFlights(List<Flights> flights) {
        return repository.saveAll(flights);
    }

    /**
     * @return all the flights as json array.
     */
    public List<Flights> getFlights() {
        return repository.findAll();
    }

    /**
     * @param id of the flight
     * @return the specific flight object as json.
     */
    public Flights getFlightById(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * @param id of the flight
     * @return a successful message of deleting
     */
    public String deleteFlight(int id) {
        repository.deleteById(id);
        return "Flight who's id =" + id + ", has been removed successfully !! ";
    }

    /**
     * @param flight
     * Update the information of specific flight
     * @return the flight object as json.
     */
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
