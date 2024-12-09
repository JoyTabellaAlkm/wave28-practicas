package com.concesionariaapi.concesionaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
    @JsonProperty()
    private String date;
    @JsonProperty()
    private String kilometers;
    @JsonProperty()
    private String descriptions;
}
