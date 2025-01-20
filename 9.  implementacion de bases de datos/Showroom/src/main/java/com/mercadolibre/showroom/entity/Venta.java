package com.mercadolibre.showroom.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private LocalDate fecha;
    private Double total;
    @Column(name = "medio_de_pago")
    private String medioDePago;
    @OneToMany
    @JoinColumn(name = "prendas_codigo")
    private List<Prenda> prendas;
}
