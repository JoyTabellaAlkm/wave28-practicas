package com.example.health.entity;

import com.example.health.common.ESymptomSeverity;

public class Symptom {
    private Long code;
    private String name;
    private ESymptomSeverity severity;

    public Symptom() {
    }

    public Symptom(Long codigo, String name, ESymptomSeverity severity) {
        this.code = codigo;
        this.name = name;
        this.severity = severity;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ESymptomSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(ESymptomSeverity severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", severity=" + severity +
                '}';
    }
}
