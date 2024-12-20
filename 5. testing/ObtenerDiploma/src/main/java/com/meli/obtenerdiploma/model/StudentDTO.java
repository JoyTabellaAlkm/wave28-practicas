package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.obtenerdiploma.validation.StartsWithUpperCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Max(value = 50, message="La longitud del nombre no puede superar los 50 caracteres")
    @StartsWithUpperCase(message = "El nombre del alumno debe comenzar con mayúscula")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacía")
    List<SubjectDTO> subjects;
}
