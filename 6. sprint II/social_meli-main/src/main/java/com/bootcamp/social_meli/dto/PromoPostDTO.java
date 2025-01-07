package com.bootcamp.social_meli.dto;

import com.bootcamp.social_meli.dto.response.ProductDTO;
import com.bootcamp.social_meli.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
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
    private Double discount;
}
