package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fecha;

    @Column(precision = 8, scale = 2)
    private BigDecimal total;

    @Column(name = "medio_de_pago")
    private String medioDePago;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<Prenda> prendas;

}
