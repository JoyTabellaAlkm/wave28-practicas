package com.melibootcamp.empresadeseguros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @Column(length = 10)
    @Size(max = 10)
    @JsonProperty("patente")
    private String patente;
    @JsonProperty("marca")
    private String marca;
    @JsonProperty("modelo")
    private String modelo;
    @Column(columnDefinition = "DATETIME", name = "ano_de_fabricacion")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("ano_fabricacion")
    private LocalDate anoFabricacion;
    @Column(name = "cantidad_ruedas")
    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculoAsignado", cascade = CascadeType.ALL)
    @JsonProperty("siniestros")
    private List<Siniestro> siniestros;
}
