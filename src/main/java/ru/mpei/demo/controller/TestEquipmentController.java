package ru.mpei.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mpei.demo.model.Equipment;
import ru.mpei.demo.repository.EquipmentRepository;

@RestController
public class TestEquipmentController {

    @Autowired
    private EquipmentRepository repo;

    @PostMapping("/equipment/save")
    public void save(@RequestBody Equipment e) {
        repo.save(e);
    }

    @GetMapping("/equipment/getById")
    public Equipment getById(@RequestParam long id) {
        return repo.getWithMeasurements(id);
    }
}
