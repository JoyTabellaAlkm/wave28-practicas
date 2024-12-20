package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El estudiante debe tener un nombre")
    String studentName;
    String message;
    @Range(min = 0, max = 10, message = "El promedio debe estar entre 0 y 10")
    Double averageScore;
    List<SubjectDTO> subjects;
}
