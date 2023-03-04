package ru.mpei.demo.repository;

import ru.mpei.demo.model.Substation;

import java.util.List;

public interface SubstationRepository {

    Substation getById(long id);

    Substation getByName(String name);

    void save(Substation s);

    void deleteById(long id);

    List<Substation> getSubstationWithPrefix(String prefix);

}
