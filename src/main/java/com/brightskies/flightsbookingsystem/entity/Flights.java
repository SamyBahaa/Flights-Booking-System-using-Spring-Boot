package com.brightskies.flightsbookingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Flights_TBL")
public class Flights {
    @Id
    @GeneratedValue
    private int id;
    private String from,to,ticket_class;
    private float departure,arrival;
    private int fare;
}
