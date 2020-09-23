package com.brightskies.flightsbookingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue
    private int nationalId;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Flights> flightslist = new ArrayList<Flights>();

}
