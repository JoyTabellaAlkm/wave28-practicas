package com.mercadolibre.miniseries.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MiniSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double rating;
    int amount_of_awards;
}
