package com.ar.mercadolibre.miniseries.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mini_series")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double rating;
    @JsonProperty("amount_of_awards")
    private int amountOfAwards;
}
