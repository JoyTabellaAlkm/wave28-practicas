package com.mercadolibre.Deportistas.dto;

public class SportDTO {
    private String name;
    private Integer level;

    public SportDTO(String nombre, Integer nivel) {
        this.name = nombre;
        this.level = nivel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
