package com.example.vaadinharjoitustyo.repository;

import com.example.vaadinharjoitustyo.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.time.LocalDateTime;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    // Hae kaikki mittaukset, joilla on määritetty henkilö
    List<Measurement> findAllByPersonIdIsNotNull();

    // Hae kaikki tietyn henkilön mittaukset
    List<Measurement> findAllByPersonId(Long personId);

    // Hae kaikki tietyn mittauslajin mittaukset
    List<Measurement> findAllByMeasurementType(String measurementType);

    // Hae mittaukset halutulta aikaväliltä
    List<Measurement> findAllByMeasurementDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    // Hae kaikki mittaukset, joilla on määritetty henkilö ja tietty mittauslaji
    List<Measurement> findAllByPersonIdAndMeasurementType(Long personId, String measurementType);

    // Hae mittaukset halutulta aikaväliltä
    List<Measurement> findAllByMeasurementDateBetween(LocalDate startDateTime, LocalDate endDateTime);

    // Hae mittaukset halutulta aikaväliltä annetun henkilön perusteella
    List<Measurement> findAllByPersonIdAndMeasurementDateBetween(Long personId, LocalDate startDate, LocalDate endDate);

    // Lisää metodi mittauksille, joilla on määritetty henkilö
    List<Measurement> findAllByPersonIsNotNull();
}
