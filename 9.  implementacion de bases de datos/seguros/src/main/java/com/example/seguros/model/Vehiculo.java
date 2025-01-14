package com.example.seguros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vehiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)

    private String patente;

    @Column(length = 20)
    private String marca;

    @Column(length = 30)
    private String modelo;
    private LocalDate fabricacion;
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculoDenunciado", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;
}
