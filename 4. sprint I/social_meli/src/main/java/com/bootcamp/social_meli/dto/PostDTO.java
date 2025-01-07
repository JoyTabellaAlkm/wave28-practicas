package com.bootcamp.social_meli.dto;

import com.bootcamp.social_meli.dto.response.ProductDTO;
import com.bootcamp.social_meli.model.Product;
import com.bootcamp.social_meli.model.User;
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
public class PostDTO {
    @JsonProperty("user_id")
    @NotNull(message = "El user_id no puede ser nulo")
    private Long userId;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "la fecha creacion no puede ser nulo")
    private LocalDate createDate;
    @NotNull(message = "Producto no puede ser nulo")
    @Valid
    private ProductDTO product;
    @NotNull(message = "Categoria no puede ser nulo")
    private Integer category;
    @NotNull(message = "El precio no puede ser nulo")
    private Double price;
}
