package com.mercadolibre.sprint1.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint1.dto.ProductDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePromoPostDto {

    @NotNull(message = "El user id no debe ser nulo")
    @Positive(message = "El id debe ser positivo")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "La fecha no debe ser nula")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    @NotNull(message = "El producto no puede ser nulo")
    private ProductDto product;

    @NotNull(message = "La categoria no debe ser nula")
    @Positive(message = "La categoria debe ser positiva")
    private Integer category;

    @NotNull(message = "El precio no debe ser nulo")
    @Positive(message = "El precio debe ser mayor a cero")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;

    @NotNull(message = "Debe ser una promoción")
    @AssertTrue(message = "Debe ser una promoción")
    @JsonProperty("has_promo")
    private boolean hasPromo;

    @NotNull(message = "El descuento no debe ser nulo")
    @Positive(message = "El descuento debe ser mayor a 0")
    private Double discount;
}
