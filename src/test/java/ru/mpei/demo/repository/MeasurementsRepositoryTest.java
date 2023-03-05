package ru.mpei.demo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.demo.model.Measurement;
import ru.mpei.demo.utils.MeasurementsComparator;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional //чтобы бд откатывалась к исходному состоянию
    //после каждого теста будет rollback
class MeasurementsRepositoryTest {

    @Autowired
    MeasurementsRepository repo;

    @Test
    void save() {
        Measurement m = new Measurement(100, 120, 100, 10, 12, 14);
        Measurement save = repo.save(m, 1);
        Assertions.assertEquals(6, save.getId());
    }

    /**
     * переопределили hashcode и equals у Measurement,
     * чтобы не учитывать list equipment
     */
    @Test
    void getById() {
        Measurement expected = new Measurement(12, 15, 12, 22, 22, 22);
        expected.setId(5);
        Optional<Measurement> actual = repo.getById(5);
        Assertions.assertEquals(expected, actual.get());

//        Assertions.assertTrue(new MeasurementsComparator().compare(expected,actual.get()));
    }

    @Test
    void delete() {
        int initCount = repo.getMeasurementsByEquipmentId(1).size();
        boolean res = repo.delete(2);
        Assertions.assertTrue(res);
        Optional<Measurement> actual = repo.getById(2);
        Assertions.assertFalse(actual.isPresent());
        int afterCount = repo.getMeasurementsByEquipmentId(1).size();
        Assertions.assertEquals(initCount, afterCount + 1);
    }

    @Test
    void save2() {
        Assertions.assertEquals(5,repo.getMeasurementsByEquipmentId(1).size());
        Measurement m1 = new Measurement(100, 120, 100, 10, 12, 14);
        Measurement m2 = new Measurement(100, 120, 100, 10, 12, 14);
        m1 = repo.save(m1, 1);
        m2 = repo.save(m2,1);
        Assertions.assertEquals(7, repo.getMeasurementsByEquipmentId(1).size());
    }

    @Test
    void getMeasurementsByEquipmentId() {
        List<Measurement> measurementsByEquipmentId = repo.getMeasurementsByEquipmentId(1);
        Assertions.assertEquals(5,measurementsByEquipmentId.size());
    }
}