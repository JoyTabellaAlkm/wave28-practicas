package com.melibootcamp.showroom.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private double total;

    @Column(name = "medio_de_pago", nullable = false)
    @JsonProperty("medio_de_pago")
    private String medioDePago;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "venta_prenda",
            joinColumns = @JoinColumn(name = "venta_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "prenda_id", referencedColumnName = "id")
    )

    @JsonProperty("lista_de_prendas")
    private List<Prenda> listaDePrendas;
}