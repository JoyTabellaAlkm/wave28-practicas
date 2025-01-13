package com.example.jewerly_api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUpdateDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("material")
    private String material;

    @JsonProperty("peso")
    private Integer weight;

    @JsonProperty("particularidad")
    private String specificity;

    @JsonProperty("posee_piedra")
    private Boolean hasStone;

    @JsonProperty("ventaONo")
    private Boolean canSell;
}
