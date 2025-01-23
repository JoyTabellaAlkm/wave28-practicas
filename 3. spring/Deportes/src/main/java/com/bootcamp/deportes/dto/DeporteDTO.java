package com.bootcamp.deportes.dto;

import com.bootcamp.deportes.model.Deporte;
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