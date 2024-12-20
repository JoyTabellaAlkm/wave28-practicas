package com.mercadolibre.testing.obtener_diploma.model;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @NotBlank
    @Size(max = 50)
    @Pattern(regexp = "^[A-Z]")
    String studentName;

    String message;

    Double averageScore;

    @Valid
    @NotEmpty
    List<SubjectDTO> subjects;
}
