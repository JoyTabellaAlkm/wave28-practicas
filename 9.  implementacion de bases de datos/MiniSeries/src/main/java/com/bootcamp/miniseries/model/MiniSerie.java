package com.bootcamp.miniseries.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Double rating;

    @Column(name = "amount_of_awards")
    int amountOfAwards;
}
