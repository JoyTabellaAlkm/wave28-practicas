package com.example.joyerialasperlas.dto;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JoyaDto {
    Long nroIdentificatorio;
    String nombre;
    String material;
    double peso;
    String particularidad;
    Boolean poseePiedra;
    Boolean ventaONo;
}
