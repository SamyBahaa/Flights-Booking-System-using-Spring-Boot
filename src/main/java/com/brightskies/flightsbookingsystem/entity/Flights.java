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
@Table
public class Flights {
    @Id
    @GeneratedValue
    private int id;
    private String fromPlace;
    private String toPlace;
    private String ticketClass;
    private float departure,arrival;
    private double fare;
    private boolean available;
}
