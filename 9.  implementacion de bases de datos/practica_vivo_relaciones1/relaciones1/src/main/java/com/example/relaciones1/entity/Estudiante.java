package com.example.relaciones1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    @OneToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

}
