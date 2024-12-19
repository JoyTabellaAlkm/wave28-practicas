package com.meli.be_java_hisp_w28_g01.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;


import java.io.Serializable;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoPostDto implements Serializable {
    @JsonProperty("user_id")
    @NotNull("El userId es obligatorio")
    Integer userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull("El date es obligatorio")
    LocalDate date;
    @JsonProperty("product")
    @NotNull("El producto es obligatorio")
    ProductDto productDto;
    @NotNull("La category es obligatoria")
    Integer category;
    @NotNull("El price es obligatorio")
    Double price;
    @JsonProperty("has_promo")
    @NotNull("El hasPromo es obligatorio")
    Boolean hasPromo;
    @NotNull("El discount es obligatorio")
    Double discount;
}
