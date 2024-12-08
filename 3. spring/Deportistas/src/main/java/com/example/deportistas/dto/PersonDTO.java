package com.example.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PersonDTO {
    private String name, last_name;
    private String sport;

    public PersonDTO(String name, String last_name, String sport) {
        this.name = name;
        this.last_name = last_name;
        this.sport = sport;
    }
}
