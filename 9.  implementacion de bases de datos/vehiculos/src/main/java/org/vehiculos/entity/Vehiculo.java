package org.vehiculos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "año_de_fabricacion")
    private Integer añoFabricacion;
    @Column(name = "cantidad_de_ruedas")
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "idVehiculo", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Siniestro> siniestros;
}
