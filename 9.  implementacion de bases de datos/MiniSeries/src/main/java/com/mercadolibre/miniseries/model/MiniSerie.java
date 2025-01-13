package com.mercadolibre.miniseries.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double rating;
    @Column(name="amount_of_awards")
    private int amountOfAwards;
}
