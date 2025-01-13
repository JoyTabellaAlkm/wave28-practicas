package com.mercadolibre.joyeria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Joya {
    @Id
    @JsonProperty("nro_identificatorio")
    @Column(name = "nro_identificatorio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    private boolean ventaONo;
}
