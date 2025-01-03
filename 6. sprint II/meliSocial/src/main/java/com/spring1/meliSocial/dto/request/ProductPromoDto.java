package com.spring1.meliSocial.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring1.meliSocial.dto.response.ProductDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPromoDto {
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

    @NotNull(message = "El campo price no puede estar vacío")
    @DecimalMax(value = "10000000", message = "El precio máximo por producto es de 10.000.000")
    @DecimalMin(value = "0.01", message = "El precio mínimo por producto es de 0.01")
    private double price;

    @JsonAlias("has_promo")
    @AssertTrue(message = "El valor del campo has_promo debe ser verdadero para admitir la promo")
    private boolean hasPromo;

    @DecimalMax(value = "1", message = "El descuento máximo no puede superar el 100%")
    @DecimalMin(value = "0.01", message = "El descuento mínimo no puede ser cero")
    private double discount;
}
