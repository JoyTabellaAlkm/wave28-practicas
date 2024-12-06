package com.mercadolibre.sports.model;

import lombok.Data;

@Data
public class Sport {

    private String name;
    private String level;

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
