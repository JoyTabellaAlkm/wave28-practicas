package com.mercadolibre.Covid19.repository;

import com.mercadolibre.Covid19.entity.PersonEntity;
import com.mercadolibre.Covid19.entity.PersonSymptomEntity;
import com.mercadolibre.Covid19.entity.SymptomEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CovidRepository implements ICovidRepository{


    //region GetData
    public List<SymptomEntity> getSymptoms(){
        List<SymptomEntity> listaSymptomFromDatabase;
        listaSymptomFromDatabase = new ArrayList<SymptomEntity>();

        listaSymptomFromDatabase.add(new SymptomEntity(
                "rojo",
                "dolor de cabeza",
                "alto"
        ));
        listaSymptomFromDatabase.add(new SymptomEntity(
                "rojo",
                "fiebre alta",
                "alto"
        ));
        listaSymptomFromDatabase.add(new SymptomEntity(
                "rojo",
                "fiebre alta",
                "alto"
        ));
        listaSymptomFromDatabase.add(new SymptomEntity(
                "rojo",
                "tos",
                "alto"
        ));
        listaSymptomFromDatabase.add(new SymptomEntity(
                "rojo",
                "perdida del gusto",
                "alto"
        ));
        listaSymptomFromDatabase.add(new SymptomEntity(
                "blanco",
                "dolor de estomago",
                "medio"
        ));
        listaSymptomFromDatabase.add(new SymptomEntity(
                "blanco",
                "dolor de articulaciones",
                "medio"
        ));
        listaSymptomFromDatabase.add(new SymptomEntity(
                "blanco",
                "cansancio",
                "medio"
        ));
        return listaSymptomFromDatabase;
    }

    public List<PersonEntity> getPeople(){
        List<PersonEntity> listaPeopleFromDatabase;
        listaPeopleFromDatabase = new ArrayList<PersonEntity>();
        listaPeopleFromDatabase.add(new PersonEntity(
                1,
                "Gabriel",
                "Apellido",
                26
        ));
        listaPeopleFromDatabase.add(new PersonEntity(
                2,
                "Klaus",
                "Biñedo",
                25
        ));
        listaPeopleFromDatabase.add(new PersonEntity(
                3,
                "Nicolas",
                "Dissel",
                21
        ));
        listaPeopleFromDatabase.add(new PersonEntity(
                4,
                "Santiago",
                "Barrelnuchi",
                21
        ));
        listaPeopleFromDatabase.add(new PersonEntity(
                5,
                "Santiago",
                "bravo",
                21
        ));
        listaPeopleFromDatabase.add(new PersonEntity(
                5,
                "Maria",
                "Silva",
                65
        ));
        listaPeopleFromDatabase.add(new PersonEntity(
                6,
                "Andres",
                "Villanueva",
                66
        ));
        listaPeopleFromDatabase.add(new PersonEntity(
                7,
                "Andres",
                "Villanueva",
                67
        ));

        return listaPeopleFromDatabase;
    }

    public List<PersonSymptomEntity> getPersonSymptom(){
        List<PersonSymptomEntity> listaPersonSymptomFromDatabase;
        listaPersonSymptomFromDatabase = new ArrayList<PersonSymptomEntity>();
        for(PersonEntity p: getPeople()){
            for(SymptomEntity s : getSymptoms()){
                listaPersonSymptomFromDatabase.add(
                        new PersonSymptomEntity(
                                p,
                                s
                        )
                );
            }
        }
        return listaPersonSymptomFromDatabase;
    }
    //endregion

    @Override
    public List<SymptomEntity> getAllSymptom() {
        List<SymptomEntity> listSymptoms = getSymptoms();
        return listSymptoms;
    }

    @Override
    public SymptomEntity getSymptomByName(String name) {
        SymptomEntity Symptom = getSymptoms().
                stream().
                filter(x -> x.getName().contains(name)).
                findFirst().
                orElse(null);
        return Symptom;
    }

    @Override
    public List<PersonSymptomEntity> getRiskPerson() {
        List<PersonSymptomEntity> listado = getPersonSymptom();
        return listado;
    }


}
