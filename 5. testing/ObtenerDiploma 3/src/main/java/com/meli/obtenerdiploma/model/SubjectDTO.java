package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
@Valid
public class SubjectDTO {
    @NotBlank(message="Las materias no puede estar en blanco")
    @Size(max = 50, message = "El estudiante debe ser menor a 50 caracteres")
    @Pattern(regexp = "^[A-Z]")
    String name;
    @NotNull(message = "El puntaje no puede ser null")
    @DecimalMin(value = "0.0", inclusive = true, message = "El puntaje no puede ser negativo")
    @DecimalMax(value = "100.0", inclusive = true, message = "El puntaje no puede ser mayor a 100")
    Double score;
}
