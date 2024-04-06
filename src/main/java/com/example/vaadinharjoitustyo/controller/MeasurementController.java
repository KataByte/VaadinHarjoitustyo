package com.example.vaadinharjoitustyo.controller;

import com.example.vaadinharjoitustyo.entity.Measurement;
import com.example.vaadinharjoitustyo.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Measurement> getMeasurementById(@PathVariable Long id) {
        Measurement measurement = measurementService.getMeasurementById(id);
        if (measurement != null) {
            return ResponseEntity.ok(measurement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Measurement> createMeasurement(@RequestBody Measurement measurement) {
        Measurement createdMeasurement = measurementService.createMeasurement(measurement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMeasurement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Measurement> updateMeasurement(@PathVariable Long id, @RequestBody Measurement measurement) {
        Measurement updatedMeasurement = measurementService.updateMeasurement(id, measurement);
        if (updatedMeasurement != null) {
            return ResponseEntity.ok(updatedMeasurement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurement(@PathVariable Long id) {
        boolean deleted = measurementService.deleteMeasurement(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/persons")
    public List<Measurement> getMeasurementsWithPersons() {
        return measurementService.getMeasurementsWithPersons();
    }

    @GetMapping("/person/{personId}")
    public List<Measurement> getMeasurementsByPerson(@PathVariable Long personId) {
        return measurementService.getMeasurementsByPerson(personId);
    }

    @GetMapping("/person/{personId}/type/{measurementType}")
    public List<Measurement> getMeasurementsByType(
            @PathVariable Long personId,
            @PathVariable String measurementType) {
        return measurementService.getMeasurementsByType(personId, measurementType);
    }

    @GetMapping("/person/{personId}/interval")
    public List<Measurement> getMeasurementsByInterval(
            @PathVariable Long personId,
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endDate) {
        // Muunna String-tyyppiset parametrit LocalDate-tyyppisiksi
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        // Kutsu MeasurementService-luokan metodia
        return measurementService.getMeasurementsByInterval(personId, start, end);
    }
}
