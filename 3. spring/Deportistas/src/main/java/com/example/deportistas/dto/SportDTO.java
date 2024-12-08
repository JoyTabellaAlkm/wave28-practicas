package com.example.deportistas.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SportDTO {
    private String name, level;

    public SportDTO(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName(){
        return name;
    }
}
