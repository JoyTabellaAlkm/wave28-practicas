package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacio")
    String name;

    @NotNull(message = "El puntaje del alumno no puede estar vacio")
    @Min(value = 1, message = "La nota debe ser minimo 1")
    @Max(value = 10, message = "La nota debe ser maximo 10")
    Double score;
}
