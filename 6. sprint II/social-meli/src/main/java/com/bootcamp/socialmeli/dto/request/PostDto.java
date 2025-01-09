package com.bootcamp.socialmeli.dto.request;

import com.bootcamp.socialmeli.dto.response.ProductDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private int id;

    @NotNull(message = "El id no puede estar vacio")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("user_id")
    private int userId;

    @NotNull(message = "La fecha no puede estar vacia")
    @FutureOrPresent(message = "La fecha de publicacion debe ser igual o mayor a la actual")
    @JsonFormat(pattern = "d-M-yyyy")
    private LocalDate date;

    @Valid
    @NotNull(message = "El producto no puede estar vacio.")
    private ProductDto product;

    @NotNull(message = "El campo no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    private int category;

    @JsonProperty("has_promo")
    private boolean hasPromo;

    private double discount;

    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private double price;
}
