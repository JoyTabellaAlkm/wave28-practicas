package com.example.relaciones1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    @ManyToMany
    @JoinTable(name="materia_profesor",
    joinColumns = @JoinColumn(name = "materia_id"),
    inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private List<Profesor> profesores;
}
