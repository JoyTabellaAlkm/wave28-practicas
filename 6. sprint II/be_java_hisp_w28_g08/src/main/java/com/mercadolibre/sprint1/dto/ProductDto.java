package com.mercadolibre.sprint1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	@JsonProperty("product_id")
	@NotNull(message = "El id no puede estar vacío.")
	@Positive(message = "El id debe ser mayor a cero.")
	private Integer id;

	@JsonProperty("product_name")
	@NotEmpty(message = "El nombre no puede estar vacío.")
	@Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "El nombre no puede poseer caracteres especiales.")
	private String name;

	@NotEmpty(message = "El tipo no puede estar vacío.")
	@Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "El tipo no puede poseer caracteres especiales.")
	private String type;

	@NotEmpty(message = "La marca no puede estar vacía.")
	@Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "La marca no puede poseer caracteres especiales.")
	private String brand;

	@NotEmpty(message = "El color no puede estar vacío.")
	@Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "El color no puede poseer caracteres especiales.")
	private String color;

	@Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
	@Pattern(regexp = "^[A-Za-z0-9 ]*$", message = "Las notas no pueden poseer caracteres especiales.")
	private String notes;

}
