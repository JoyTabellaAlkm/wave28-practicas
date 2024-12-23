package com.starwars.spring.dto;

public record PersonajeDTO(
        Integer id,
        String name,
        Integer height,
        Integer mass,
        String gender,
        String homeworld,
        String species
) {
}
