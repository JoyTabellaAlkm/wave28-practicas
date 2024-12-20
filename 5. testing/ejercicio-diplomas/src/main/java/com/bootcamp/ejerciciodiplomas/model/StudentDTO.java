package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El estudiante debe tener un nombre")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    List<SubjectDTO> subjects;
}
