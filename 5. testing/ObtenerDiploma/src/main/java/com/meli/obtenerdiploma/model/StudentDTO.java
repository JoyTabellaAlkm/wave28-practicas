package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.validation.StartsWithUpperCase;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 50, message="La longitud del nombre no puede superar los 50 caracteres")
    @StartsWithUpperCase(message = "El nombre del alumno debe comenzar con mayúscula")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacía")
    @Valid
    List<SubjectDTO> subjects;
}
