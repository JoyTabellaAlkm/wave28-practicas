package com.bootcamp.miniseriesjpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mini_series")
@Getter
@Setter
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private double rating;
    int amountOfAwards;
}
