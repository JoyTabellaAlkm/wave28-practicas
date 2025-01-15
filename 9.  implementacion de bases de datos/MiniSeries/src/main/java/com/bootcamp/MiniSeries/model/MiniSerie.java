package com.bootcamp.MiniSeries.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    @Column (name = "amount_of_awards")
    private int amountOfAwards;

    public MiniSerie() {
    }

    public MiniSerie(Long id, String name, Double rating, int amount_of_awards) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.amountOfAwards = amount_of_awards;
    }


}
