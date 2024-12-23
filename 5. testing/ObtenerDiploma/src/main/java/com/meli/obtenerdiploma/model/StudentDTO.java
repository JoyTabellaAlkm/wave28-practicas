package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;

import javax.swing.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del estudiante no puede estar vacío")
    @Pattern(regexp = "^[A-Z][A-Za-zñÑáéíóúÁÉÍÓÚ]*$", message = "El nombre del alumno debe comenzar con mayuscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String studentName;


    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía")
    List<@Valid SubjectDTO> subjects;
}
/*{
    "name": "Matemática",
            "score": 10
            },
            {
            "name": "Física",
            "score": 7
            },
            {
            "name": "Química",
            "score": 6
            }*/
