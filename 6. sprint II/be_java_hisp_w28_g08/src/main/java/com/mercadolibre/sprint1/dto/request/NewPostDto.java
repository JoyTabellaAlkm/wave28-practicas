package com.mercadolibre.sprint1.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint1.dto.ProductDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPostDto {

    @JsonProperty("user_id")
    @NotNull(message = "El  id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;

    @Valid
    @NotNull(message = "El producto no puede ser nulo.")
    private ProductDto product;

    @NotNull(message = "El campo no puede estar vacío.")
    private Integer category;

    @NotNull
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;

}
