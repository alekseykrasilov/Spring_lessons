package ru.mpei.demo.repository;

import ru.mpei.demo.model.Equipment;

public interface EquipmentRepository {

    void save(Equipment e);

    boolean delete(long id);

    Equipment getWithMeasurements(long id);

    Equipment get(long id);

}
