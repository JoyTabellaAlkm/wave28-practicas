package com.bootcamp.primerjpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Double rating;
    @Column
    private int amount_of_awards;
}
