package ru.mpei.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mpei.demo.model.Measurement;
import ru.mpei.demo.repository.MeasurementsRepository;

@RestController
public class MeasurementController {

    @Autowired
    private MeasurementsRepository repo;

    @PostMapping("/measurement/add")
    public void addMeasurement(@RequestBody Measurement m) {
        repo.save(m);
    }

    @GetMapping("/measurement/get")
    public Measurement getById(@RequestParam long id) {
        return repo.getById(id);
    }
}
