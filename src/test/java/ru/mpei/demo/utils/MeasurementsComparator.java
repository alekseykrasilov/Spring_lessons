package ru.mpei.demo.utils;

import ru.mpei.demo.model.Measurement;

public class MeasurementsComparator {

    public boolean compare(Measurement m1, Measurement m2) {
        return m1.getId() == m2.getId() && m1.getIa() == m2.getIa() &&
                m1.getIb() == m2.getIb() && m1.getIc() == m2.getIc();

    }
}
