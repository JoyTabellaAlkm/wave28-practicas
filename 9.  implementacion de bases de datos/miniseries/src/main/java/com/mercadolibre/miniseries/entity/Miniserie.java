package com.mercadolibre.miniseries.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Miniserie {

    @Id
    @GeneratedValue
    private long id;
    
    @Column
    private String name;

    @Column
    private double rating;

    @Column(name = "amount_of_awards")
    private int amountOfAwards;

}
