package ru.mpei.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.demo.model.Measurement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class MeasurementsRepository {

    @PersistenceContext
    private EntityManager em;

    public boolean save(Measurement m) {
        if (m.getId() == 0) {
            em.persist(m);
        } else {
            em.merge(m);
        }
        return true;
    }

    public Measurement getById(long id) {
        Measurement measurement = em.find(Measurement.class, id);
        return measurement;
    }
}
