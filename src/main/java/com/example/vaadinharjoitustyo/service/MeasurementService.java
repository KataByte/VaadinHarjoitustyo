package com.example.vaadinharjoitustyo.service;

import com.example.vaadinharjoitustyo.entity.Measurement;
import com.example.vaadinharjoitustyo.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Measurement getMeasurementById(Long id) {
        Optional<Measurement> measurementOptional = measurementRepository.findById(id);
        return measurementOptional.orElse(null);
    }

    public Measurement createMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public Measurement updateMeasurement(Long id, Measurement measurement) {
        Optional<Measurement> existingMeasurementOptional = measurementRepository.findById(id);
        if (existingMeasurementOptional.isPresent()) {
            Measurement existingMeasurement = existingMeasurementOptional.get();
            existingMeasurement.setBloodPressure(measurement.getBloodPressure());
            existingMeasurement.setWeight(measurement.getWeight());
            // Continue updating other attributes as needed
            return measurementRepository.save(existingMeasurement);
        } else {
            return null; // Return null if the measurement with the given id doesn't exist
        }
    }

    public boolean deleteMeasurement(Long id) {
        Optional<Measurement> measurementOptional = measurementRepository.findById(id);
        if (measurementOptional.isPresent()) {
            measurementRepository.deleteById(id);
            return true; // Return true if the measurement was successfully deleted
        } else {
            return false; // Return false if the measurement with the given id doesn't exist
        }
    }

    public List<Measurement> getMeasurementsWithPersons() {
        return measurementRepository.findAllByPersonIsNotNull();
    }

    public List<Measurement> getMeasurementsByPerson(Long personId) {
        return measurementRepository.findAllByPersonId(personId);
    }

    public List<Measurement> getMeasurementsByType(Long personId, String measurementType) {
        return measurementRepository.findAllByPersonIdAndMeasurementType(personId, measurementType);
    }

    public List<Measurement> getMeasurementsByInterval(Long personId, LocalDate startDate, LocalDate endDate) {
        return measurementRepository.findAllByPersonIdAndMeasurementDateBetween(personId, startDate, endDate);
    }
}
