package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "Student name must not be blank or null")
    @Size(min = 3, max = 20, message = "Student name must contain between 3 and 20 characters")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    List<SubjectDTO> subjects;
}
