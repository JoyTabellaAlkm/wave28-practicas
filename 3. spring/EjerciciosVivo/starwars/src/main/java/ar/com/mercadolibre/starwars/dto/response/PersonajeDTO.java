package ar.com.mercadolibre.starwars.dto;

import lombok.Data;

@Data
public class PersonajeDTO {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private int height;
    private int mass;
}
