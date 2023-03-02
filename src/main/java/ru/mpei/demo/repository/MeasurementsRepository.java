package ru.mpei.demo.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MeasurementsRepository {

    @PersistenceContext
    private EntityManager em;
}
