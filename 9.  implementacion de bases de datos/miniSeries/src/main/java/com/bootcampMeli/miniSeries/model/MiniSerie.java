package com.bootcampMeli.miniSeries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "miniSerie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(nullable = false)
    private Double rating;
    @Column(name = "amount_of_awards", nullable = false)
    private int amountOfAwards;
}
