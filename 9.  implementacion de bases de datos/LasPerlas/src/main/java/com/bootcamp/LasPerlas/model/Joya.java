package com.bootcamp.LasPerlas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@Table(name = "joyas")
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String material;

    @Column
    private Double peso;

    @Column
    private String particularidad;

    @Column
    private boolean posee_piedra;

    @Column
    private boolean ventaONo;

    public Joya() {
    }

}
