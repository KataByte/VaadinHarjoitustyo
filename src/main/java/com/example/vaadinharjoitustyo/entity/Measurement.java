package com.example.vaadinharjoitustyo.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long personId;
    // Getter ja setter person-ominaisuudelle
    @Setter
    @Getter
    private Long person;

    private LocalDate measurementDate;
    @Getter
    @Setter
    private String measurementType;

    // Getterit ja setterit bloodPressure- ja weight-ominaisuuksille
    @Setter
    @Getter
    private double bloodPressure;
    @Setter
    @Getter
    private double weight;

}
