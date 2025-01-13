
package com.example.jewerly_api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestJewelDto {

    @JsonProperty("nombre")
    @NotNull(message = "El nombre no puede estar vacio")
    private String name;

    @JsonProperty("material")
    @NotNull(message = "El material no puede estar vacio")
    private String material;

    @JsonProperty("peso")
    @NotNull(message = "El peso no puede estar vacio")
    @Min(value = 1, message = "El peso no puede ser menor a 1.")
    private Integer weight;

    @JsonProperty("particularidad")
    @NotNull(message = "La particularidad no puede estar vacio")
    private String specificity;

    @JsonProperty("posee_piedra")
    @NotNull(message = "posee_piedra no puede estar vacio")
    private Boolean hasStone;

    @JsonProperty("ventaONo")
    @NotNull(message = "ventaONo no puede estar vacio")
    @AssertTrue(message = "ventaONo debe ser true")
    private Boolean canSell;
}