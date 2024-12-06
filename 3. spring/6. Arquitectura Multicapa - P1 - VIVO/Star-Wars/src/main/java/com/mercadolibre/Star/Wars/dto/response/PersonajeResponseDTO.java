package com.mercadolibre.Star.Wars.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonajeResponseDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("mass")
    private Integer mass;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("species")
    private String species;
}
