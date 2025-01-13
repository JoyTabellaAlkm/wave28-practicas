package com.mercadolibre.qatesters.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    @Column(name="number_of_tries")
    int numberOfTries;
    @Column(name="last_update")
    LocalDate lastUpdate;
}
