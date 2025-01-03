package com.mercadolibre.socialmeli_g3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromoProductPostDTO {

    @NotNull(message = "The user id must be provided")
    @Positive(message = "The user id must be a positive number")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "The date must be provided")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$", message = "The date must be in the format dd-mm-yyyy")
    private String date;

    @Valid
    private ProductDTO product;

    @NotNull(message = "The category must be provided")
    private Integer category;

    @NotNull(message = "The price must be provided")
    @Positive(message = "The price must be a positive number")
    @Max(value = 10000000, message = "The price must be less than 10000000")
    private Double price;

    @JsonProperty("has_promo")
    @NotNull(message = "The hasPromo property must be provided")
    private Boolean hasPromo;
    @NotNull(message = "The discount must be provided")
    private Double discount;
}