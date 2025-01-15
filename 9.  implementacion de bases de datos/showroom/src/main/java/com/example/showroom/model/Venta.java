package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Setter
@Getter
@Table(name = "Ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private String fecha;
    private Double total;
    @Column(name = "medio_pago")
    private String medioDePago;

    @OneToMany(mappedBy = "venta")
    private List<Prenda> prendas;
}
