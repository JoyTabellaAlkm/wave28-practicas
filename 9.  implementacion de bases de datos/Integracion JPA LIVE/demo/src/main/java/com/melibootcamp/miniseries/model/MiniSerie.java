package com.melibootcamp.miniseries.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table (name = "miniseries")
public class MiniSerie {
    // 5. Crear una clase MiniSerie dentro del paquete “model”,
    // que tenga los atributos Long id, String name,
    // Double rating e int amount_of_awards.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    private double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
