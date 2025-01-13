package com.mercadolibre.ejerciciojpajoyas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jewelry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_jewelry")
    Long id;

    String name;

    String material;

    Double weight;

    String description;

    Boolean hasStone;

    Boolean forSale;

}
