package ru.mpei.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mpei.demo.model.BadEquipmentDTO;
import ru.mpei.demo.model.MeasurementDTO;
import ru.mpei.demo.repository.MeasurementsRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private MeasurementsRepo repo;
//    private final Map<String, List<MeasurementDTO>> data = new HashMap<>();

    @Override
    public void addMeasurement(MeasurementDTO dto) {
//        if (!data.containsKey(dto.getEquipmentId())){
//            data.put(dto.getEquipmentId(), new ArrayList<>());
//        }
//        data.get(dto.getEquipmentId()).add(dto);
        boolean res = repo.addSample(dto);
        if (res) {
            log.info("Successfully added measurement");
        } else {
            log.warn("Error during measurement adding");
        }
    }

    @Override
    public BadEquipmentDTO getBadEquipment(String ssId) {
        return new BadEquipmentDTO(ssId, List.of("Trans-1"));
    }

}
