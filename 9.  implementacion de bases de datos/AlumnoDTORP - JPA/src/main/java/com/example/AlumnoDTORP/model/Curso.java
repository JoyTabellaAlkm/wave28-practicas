package com.example.AlumnoDTORP.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    @Column
    private String nombre;
    @Column
    private String grado;
    @Column
    private Boolean certificado;
    @Column
    private Double duracion;


}
