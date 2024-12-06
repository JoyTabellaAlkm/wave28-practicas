package com.example.health.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Person {
    private int id;
    private String name;
    private String surname;
    private int age;
    private List<Long> symptoms = new ArrayList<>(); // lista con codigos de sintomas

    public Person() {
    }

    public Person(int id, String name, String surname, int age, List<Long> symptoms) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.symptoms = symptoms;
    }

    public Person(int id, String name, String surname, int edad) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSymptoms(List<Long> symptoms) {
        this.symptoms = symptoms;
    }

    public void addSymptom(Long symptom){
        this.symptoms.add(symptom);
    }
}
