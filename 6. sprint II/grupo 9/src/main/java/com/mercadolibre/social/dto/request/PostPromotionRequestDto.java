package com.mercadolibre.social.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPromotionRequestDto {
    @JsonProperty("user_id")
    @NotNull(message = "El ID no puede estar vacio")
    @Min(value = 1, message = "El ID debe ser mayor a 0")
    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía")
    private LocalDate date;
    private ProductDto product;
    @NotNull(message = "El campo no puede estar vacio")
    private Integer category;
    @NotNull(message = "El campo no puede estar vacio")
    @DecimalMax(value = "10000000.00", message = "El precio no puede ser mayor a 10.000.000")
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    @DecimalMin(value = "0.0", message = "El valor del discount no puede ser menor que 0")
    @DecimalMax(value = "1.0", message = "El valor del discount no puede ser mayor que 1")
    private Double discount;
}
