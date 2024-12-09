package com.mercadolibre.Covid19.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

public class SymptomEntity {
    private String code;
    private String name;
    private String levelOfRisk;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevelOfRisk() {
        return levelOfRisk;
    }

    public void setLevelOfRisk(String levelOfRisk) {
        this.levelOfRisk = levelOfRisk;
    }

    public SymptomEntity() {
    }

    public SymptomEntity(String code, String name, String levelOfRisk) {
        this.code = code;
        this.name = name;
        this.levelOfRisk = levelOfRisk;
    }
}
