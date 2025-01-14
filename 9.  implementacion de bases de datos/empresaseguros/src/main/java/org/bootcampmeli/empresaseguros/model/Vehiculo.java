package org.bootcampmeli.empresaseguros.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Vehiculo {
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("patente")
    private String patente;

    @Column(nullable = false)
    @JsonProperty("marca")
    private String marca;

    @Column(nullable = false)
    @JsonProperty("modelo")
    private String modelo;

    @Column(name = "ano_fabricacion", nullable = false)
    @JsonProperty("año_fabricacion")
    private int añoFabricacion;

    @Column(name = "cantidad_ruedas", nullable = false)
    @JsonProperty("cantidad_ruedas")
    private int cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo")
    @JsonProperty("siniestros")
    private List<Siniestro> siniestros;
}
