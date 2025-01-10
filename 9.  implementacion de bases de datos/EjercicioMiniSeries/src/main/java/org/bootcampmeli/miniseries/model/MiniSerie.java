package org.bootcampmeli.miniseries.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
