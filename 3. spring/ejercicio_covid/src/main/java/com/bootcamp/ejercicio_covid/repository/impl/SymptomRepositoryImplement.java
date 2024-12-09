package com.bootcamp.ejercicio_covid.repository.impl;

import com.bootcamp.ejercicio_covid.entity.Symptom;
import com.bootcamp.ejercicio_covid.repository.ISymptomRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SymptomRepositoryImplement implements ISymptomRepository {

    private List<Symptom> syptomList = List.of(
            new Symptom(1L,"Fiebre","Media"),
            new Symptom(2L,"Dolor de cabesa","Normnal"),
            new Symptom(3L,"Tos con sangre","Alta")
    );

    @Override
    public List<Symptom> findAll() {
        return syptomList;
    }

    @Override
    public String findGravityLevelByName(String name) {
        return syptomList.stream().filter(syptom -> syptom.getName().equals(name)).findFirst().get().getGravityLevel();
    }
}
