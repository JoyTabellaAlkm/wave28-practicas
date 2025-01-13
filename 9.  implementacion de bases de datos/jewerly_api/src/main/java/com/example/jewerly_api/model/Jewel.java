package com.example.jewerly_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String material;

    @Column
    private Integer weight;

    @Column
    private String specificity;

    @Column
    private Boolean hasStone;

    @Column
    private Boolean canSell;
}
