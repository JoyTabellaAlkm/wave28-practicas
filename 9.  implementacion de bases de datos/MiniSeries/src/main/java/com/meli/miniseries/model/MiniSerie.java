package com.meli.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mini-serie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private Double rating;
     @Column(name = "amount_of_awards")
     private int amountOfAwards;
}
