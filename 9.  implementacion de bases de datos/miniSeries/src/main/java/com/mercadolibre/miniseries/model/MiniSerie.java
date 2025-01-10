package com.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Miniserie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column()
    private Double rating;
    @Column(name = "amount_of_awards")
    private Integer amountOfAwards;
}
