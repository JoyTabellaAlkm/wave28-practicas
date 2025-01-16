package com.mercadolibre.showroom.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private LocalDate fecha;
    private Double total;

    @Column(name = "medio_de_pago")
    @JsonProperty("medio_de_pago")
    private String medioDePago;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "venta_prenda",
        joinColumns = @JoinColumn(name = "venta_numero"),
        inverseJoinColumns = @JoinColumn(name = "prenda_codigo")
    )
    private List<Prenda> prendas;

}
