package com.meli.be_java_hisp_w28_g01.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDto implements Serializable {
    @JsonProperty("user_id")
    @NotNull(message = "El  id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    Integer userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message =  "La fecha no puede estar vacía.")
    LocalDate date;

    @JsonProperty("product")
    @NotNull(message =  "El campo no puede estar vacío.")
    @Valid
    ProductDto productDto;

    @NotNull(message =  "El campo no puede estar vacío.")
    Integer category;

    @NotNull(message =  "El campo no puede estar vacío.")
    @Max(value = 10_000_000, message = "El precio máximo por producto es de 10.000.000")
    Double price;
}
