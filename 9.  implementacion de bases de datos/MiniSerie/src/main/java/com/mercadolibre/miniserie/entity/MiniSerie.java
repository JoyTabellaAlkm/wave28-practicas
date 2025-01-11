package com.mercadolibre.miniserie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "miniserie")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double rating;
    private int amount_of_awards;

    public MiniSerie() {
    }

    public MiniSerie(Long id, String name, Double rating, int amount_of_awards) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.amount_of_awards = amount_of_awards;
    }


}
