package com.melibootcamp.lasperlas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    @JsonProperty("nro_identificatorio")
    private Long id;
    @Column(length = 50)
    @Size(max = 50)
    private String nombre;
    @Column(length = 50)
    private String material;
    private double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    @Column(name = "venta_o_no")
    @JsonProperty("venta_o_no")
    private boolean ventaONo;

}
