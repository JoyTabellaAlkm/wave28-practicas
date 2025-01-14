package com.example.siniestros.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "fecha_siniestro")
    LocalDate fechaSiniestro;
    @Column(name = "perdida_valor")
    double perdidaValor;
    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    Vehiculo vehiculo;
}
