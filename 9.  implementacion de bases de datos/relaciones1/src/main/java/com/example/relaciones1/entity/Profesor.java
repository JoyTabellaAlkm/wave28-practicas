package com.example.relaciones1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    @ManyToMany(mappedBy = "profesores")
    private List<Materia> materias;
    @ManyToMany(mappedBy = "profesores")
    private List<Curso> cursos;
}
