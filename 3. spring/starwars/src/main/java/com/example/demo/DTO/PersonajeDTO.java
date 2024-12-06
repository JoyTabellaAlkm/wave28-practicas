package com.example.demo.DTO;

import com.example.demo.Model.CustomIntDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PersonajeDTO {

    private String name;
    private int height;
    private int mass;

    private String gender;

    private String homeworld;

    private String species;
}
