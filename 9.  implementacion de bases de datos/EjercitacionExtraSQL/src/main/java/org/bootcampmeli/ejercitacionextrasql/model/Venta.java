package org.bootcampmeli.ejercitacionextrasql.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate fecha;

    private double total;

    @Column(name = "medio_de_pago")
    private String medioDePago;

    @ManyToMany
    @JoinTable(
            name = "venta_prenda",
            joinColumns = @JoinColumn(name = "venta_numero"),
            inverseJoinColumns = @JoinColumn(name = "prenda_codigo")
    )
    private List<Prenda> prendas;



}
