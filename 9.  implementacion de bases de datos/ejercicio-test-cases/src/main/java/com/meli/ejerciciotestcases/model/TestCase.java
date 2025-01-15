package com.meli.ejerciciotestcases.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Data
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long id;

    private String description;
    private Boolean tested;
    private Boolean passed;

    @Column(name = "number_of_tries")
    private int numberOfTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

}
