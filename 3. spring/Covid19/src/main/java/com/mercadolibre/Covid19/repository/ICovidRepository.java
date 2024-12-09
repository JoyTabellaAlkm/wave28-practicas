package com.mercadolibre.Covid19.repository;

import com.mercadolibre.Covid19.entity.PersonSymptomEntity;
import com.mercadolibre.Covid19.entity.SymptomEntity;

import java.util.List;

public interface ICovidRepository {

    public List<SymptomEntity> getAllSymptom();
    public SymptomEntity getSymptomByName(String Name);
    public List<PersonSymptomEntity> getRiskPerson();

}
