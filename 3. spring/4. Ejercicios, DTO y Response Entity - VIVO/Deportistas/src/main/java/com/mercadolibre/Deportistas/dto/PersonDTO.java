package com.mercadolibre.Deportistas.dto;

import com.mercadolibre.Deportistas.model.Sport;

public class PersonDTO {
    private String name;
    private String lastName;
    private Integer age;
    private SportDTO sport;

    public PersonDTO(String name, String lastName, Integer age, SportDTO sport) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SportDTO getSport() {
        return sport;
    }

    public void setSport(SportDTO sport) {
        this.sport = sport;
    }
}
