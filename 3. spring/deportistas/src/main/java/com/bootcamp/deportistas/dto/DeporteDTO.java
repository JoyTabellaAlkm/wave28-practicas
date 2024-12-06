package com.bootcamp.deportistas.dto;

import com.bootcamp.deportistas.model.Deporte;
import lombok.Data;

@Data
public class DeporteDTO {
    private String name;
    private String level;

    public DeporteDTO(Deporte sport) {
        this.name = sport.getName();
        this.level = sport.getLevel();
    }
}