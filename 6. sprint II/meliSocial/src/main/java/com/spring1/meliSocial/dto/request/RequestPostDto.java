package com.spring1.meliSocial.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring1.meliSocial.dto.response.ProductDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "post_id", "date", "product", "category", "price"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestPostDto {
    @JsonAlias("user_id")
    @Min(value = 1, message = "El id del usuario debe ser mayor a cero")
    private int userId;

    @NotNull(message = "La fecha no puede estar vacía")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductDto product;

    @NotNull(message = "El campo category no puede estar vacío")
    @Min(value = 1, message = "El category debe ser mayor a cero")
    private int category;

    @NotNull(message = "El campo no puede estar vacío")
    @DecimalMax(value = "10000000", message = "El precio máximo por producto es de 10.000.000")
    @DecimalMin(value = "0.01", message = "El precio mínimo por producto es de 0.01")
    private double price;
}
