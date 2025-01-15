package org.showroommysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venta {

    @Id
    private int numero;
    private LocalDate fecha;
    private double total;
    @Column(name = "medio_de_pago")
    private String medioDePago;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "venta_ropa",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "ropa_id")
    )
    private Set<Ropa> ropa = new HashSet<>();

}
