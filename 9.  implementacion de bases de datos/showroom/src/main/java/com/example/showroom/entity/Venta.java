package com.example.showroom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Setter @Getter @Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numero;
    LocalDate fecha;
    Double total;
    String medioPago;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "venta_prenda",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "prenda_id")
    )
    List<Prenda> prendas;
}
