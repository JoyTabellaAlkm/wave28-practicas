package com.bootcamp.social_meli.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDTO extends PostDTO{
    @NotNull(message = "El campo has_promo no puede ser nulo")
    private Boolean has_promo;
    @NotNull(message = "El descuento no puede ser nulo")
    @Min(value = 1, message = "El descuento no puede ser menor a 1.00%")
    @Max(value = 100, message = "El descuento no puede ser mayor a 100.00%")
    private Double discount;
}
