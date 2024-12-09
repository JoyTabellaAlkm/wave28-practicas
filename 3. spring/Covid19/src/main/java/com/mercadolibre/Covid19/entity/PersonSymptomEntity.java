package com.mercadolibre.Covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class PersonSymptomEntity {
    private PersonEntity persona;
    private SymptomEntity symptom;

    public PersonSymptomEntity(PersonEntity persona, SymptomEntity symptom) {
        this.persona = persona;
        this.symptom = symptom;
    }

    public PersonEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonEntity persona) {
        this.persona = persona;
    }

    public SymptomEntity getSymptom() {
        return symptom;
    }

    public void setSymptom(SymptomEntity symptom) {
        this.symptom = symptom;
    }
}
