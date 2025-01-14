package com.example.joyerialasperlas.entity;

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
@Entity
@Table(name = "joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nro_identificatorio")
    Long nroIdentificatorio;
    String nombre;
    String material;
    double peso;
    String particularidad;
    @Column(name = "posee_piedra")
    Boolean poseePiedra;
    @Column(name = "venta_o_no")
    Boolean ventaONo;
    @PrePersist
    public void prePersist() {
        if (ventaONo == null) {
            ventaONo = true; // O cualquier valor predeterminado que desees
        }
    }
}
