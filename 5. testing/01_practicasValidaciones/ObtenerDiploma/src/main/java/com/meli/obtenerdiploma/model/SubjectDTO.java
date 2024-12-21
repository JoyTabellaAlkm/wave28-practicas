package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z][a-zA-ZÀ-ÿ]*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    String name;
    @NotNull(message = "La nota no puede estar vacía.")
    @Min(value = 0, message = "La minima nota es 0.0")
    @Max(value = 10, message = "La maxima nota es 10")
    Double score;
}
