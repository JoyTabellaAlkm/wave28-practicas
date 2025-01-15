package com.ar.mercadolibre.showroom.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private Date fecha;
    private double total;
    @Column(name = "medio_de_pago")
    private String medioDePago;
    @OneToMany(mappedBy = "sale")
    private List<Clothe> listaDePrendas;
}
