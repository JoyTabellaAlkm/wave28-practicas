package com.example.demoUnitTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    @NotNull(message = "El codigo es obligatorio")
    @Positive(message = "El valor debe ser POSITIVO")
    private Integer codigo;
    @Size(min = 3, max= 10, message = "El nombre debe tener al menos 3 caracteres")
    @NotNull(message = "El nombre es obligatorio")
    private String nombre;

    @Positive(message = "El valor debe ser POSITIVO")
    @JsonProperty("promedio_curso")
    private Double promedioCurso;
}
