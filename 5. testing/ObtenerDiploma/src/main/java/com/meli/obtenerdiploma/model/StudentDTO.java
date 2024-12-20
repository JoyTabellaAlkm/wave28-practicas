package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @javax.validation.constraints.NotBlank(message = "El estudiante debe tener un nombre")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    List<SubjectDTO> subjects;
}
