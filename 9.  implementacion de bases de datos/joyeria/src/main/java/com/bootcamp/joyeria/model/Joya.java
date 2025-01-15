package com.bootcamp.joyeria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nro_identificatorio")
    @JsonProperty("nro_identificatorio")
    private Long id;
    @Column
    private String nombre;
    @Column
    private String material;
    @Column
    private Double peso;
    @Column
    private String particularidad;
    @Column(name = "posee_piedra")
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
    @Column(name = "venta_o_no")
    @JsonProperty("venta_o_no")
    private Boolean ventaONo;
}
