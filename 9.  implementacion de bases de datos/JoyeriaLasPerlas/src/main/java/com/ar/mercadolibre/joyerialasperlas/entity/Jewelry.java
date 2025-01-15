package com.ar.mercadolibre.joyerialasperlas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "jewelries")
public class Jewelry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jewelryId;
    private String name;
    private Material material;
    private Double weight;
    private String particularity;
    @JsonProperty("posses_stone")
    private Boolean possesStone;
    @JsonProperty("is_on_sale")
    private Boolean isOnSale;
}
