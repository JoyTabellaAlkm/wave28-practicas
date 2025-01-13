package com.example.JoyeriaLasPerlas.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.annotation.Order;

@Getter
@Setter
@Entity
@Table(name = "joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private boolean ventaONo = true;

}
