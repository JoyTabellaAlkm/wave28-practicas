package com.demo.demo.model;

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
    private Long numero;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "total", nullable = false)
    private Double total;
    @Column(name = "medio_de_pago", nullable = false)
    private String medioDePago;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<Prenda> prendas;
}
