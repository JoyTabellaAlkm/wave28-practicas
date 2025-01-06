package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PromoPostDto {
    @JsonProperty("post_id")
    private int postId;
    @Min(value = 1, message = "El 'user_id' debe ser mayor a cero")
    @NotNull(message = "El 'user_id' no puede estar vacio")
    @JsonProperty("user_id")
    private Integer seller;
    @NotNull(message = "La fecha en 'date' no puede estar vacía")
    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    @Valid
    private ProductDto product;
    @Min(value = 1, message = "El campo 'category' debe ser mayor que cero")
    @NotNull(message = "El campo 'category' no puede estar vacio")
    @JsonProperty("category")
    private int categoryId;
    @DecimalMin(value = "0.0", message = "El campo 'price' no puede estar vacio")
    @DecimalMax(value = "10000000.0", message = "El precio maximo por producto es de 10.000.000")
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

}
