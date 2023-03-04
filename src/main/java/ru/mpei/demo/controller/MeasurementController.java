package ru.mpei.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mpei.demo.model.Measurement;
import ru.mpei.demo.repository.MeasurementsRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class MeasurementController {

    @Autowired
    private MeasurementsRepository repo;

    @PostMapping("/measurement/add")
    public void addMeasurement(@RequestBody Measurement m, @RequestParam long equipmentId) {
        repo.save(m,equipmentId);
    }

    @GetMapping("/measurement/get")
    public Measurement getById(@RequestParam long id) {
        Optional<Measurement> res = repo.getById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new RuntimeException("Entity with Id: " + id + " not found");
        }
    }

    @DeleteMapping("/measurement/delete")
    public boolean deleteById(@RequestParam long id) {
        return repo.delete(id);
    }

    @GetMapping("/measurement/getByEquipmentId")
    public List<Measurement> findMeasurementsByUa(@RequestParam long eqId) {
        return repo.getMeasurementsByEquipmentId(eqId);
    }
}
