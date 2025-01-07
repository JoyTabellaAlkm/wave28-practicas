package com.bootcamp.social_meli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
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
public class PostDTO {
    @JsonProperty("user_id")
    @NotNull(message = "El user_id no puede ser nulo.")
    @Min(value = 1, message = "El id del usuario debe ser mayor o igual a 1.")
    private Long userId;
    @JsonProperty("date")
    @NotNull(message = "la fecha de creacion no puede ser nulo.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate createDate;
    @NotNull(message = "Producto no puede ser nulo.")
    @Valid
    private ProductDTO product;
    @NotNull(message = "categoria no puede ser nulo.")
    private Integer category;
    @NotNull(message = "El precio no puede ser nulo.")
    @Min(value = 1, message = "El precio mínimo por producto es de 1.")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000.")
    private Double price;
}
