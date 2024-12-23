package com.meli.obtenerdiploma.model;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @Valid
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "[A-Z][a-zA-Z]*$", message = "El nombre del alumno debe comenzar por mayúscula.")
    @NotBlank(message = "El nombre del alumno no puede estar vacio")
    String studentName;

    String message;

    Double averageScore;

    @Valid
    @NotEmpty(message = "La lista no puede estar vacía")
    List<SubjectDTO> subjects;
}
