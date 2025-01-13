package com.mercadoLibre.MiniSeries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    private int amount_of_awards;
}
