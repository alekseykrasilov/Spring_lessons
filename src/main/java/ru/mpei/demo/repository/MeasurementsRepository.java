package ru.mpei.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.demo.model.Equipment;
import ru.mpei.demo.model.Measurement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MeasurementsRepository {

    @PersistenceContext
    private EntityManager em;

    public Measurement save(Measurement m, long equipmentId) {
        if (m.getId() == 0) {
            Equipment reference = em.getReference(Equipment.class, equipmentId);
            m.setEquipment(reference);
            em.persist(m);
            return m;
        } else {
            return em.merge(m);
        }
    }

    public Optional<Measurement> getById(long id) {
        return Optional.ofNullable(em.find(Measurement.class, id));
    }

    public boolean delete(long mId) {
        int res = em.createQuery("delete from Measurement m where m.id =:mId")
                .setParameter("mId", mId)
                .executeUpdate();
        return res != 0;

//        Optional<Measurement> res = getById(id);
//        if (res.isPresent()) {
//        em.remove(res.get());
//        return true;
//        } else {
//            return false;
//        }
    }

    public List<Measurement> getMeasurementsByEquipmentId(long id) {
        List<Measurement> result = em.createQuery("select m from Measurement m where m.equipment.id =:id", Measurement.class)
                .setParameter("id", id)
                .getResultList();
        return result;
    }
}
