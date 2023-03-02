package ru.mpei.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.mpei.demo.model.BadEquipmentDTO;
import ru.mpei.demo.model.MeasurementDTO;
import ru.mpei.demo.service.EquipmentService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@Slf4j
public class EquipmentController {
    @Autowired
    private EquipmentService service;

    @PostMapping("/data/add")
    public void addMeasurement(@RequestBody MeasurementDTO mdto) {
        log.info("Received new data {}", mdto);
        service.addMeasurement(mdto);
    }

    @GetMapping("/equipment/get-bad-items")
    public BadEquipmentDTO findBadEquipment(@RequestParam(name = "ssId") String substationId) {
        return service.getBadEquipment(substationId);
    }

    @GetMapping("/data/test")
    public String test(@RequestParam String name, @RequestParam(defaultValue = "2") int count) {
        return "Hello " + name + "!" + count;
    }

}
