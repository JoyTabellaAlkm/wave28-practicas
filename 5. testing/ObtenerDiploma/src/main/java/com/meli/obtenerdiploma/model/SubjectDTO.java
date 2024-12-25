package com.meli.obtenerdiploma.model;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacío")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula")
    String name;

    @NotNull(message = "La nota de la materia no puede estar vacía")
    @Min(value = 0, message = "La nota mínima es 0")
    @Max(value = 10, message = "La nota máxima es 10")
    Double score;
}
