package com.example.qatesters.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TestCase")
@Table(name = "test_cases")
public class TestCase {
    @Id
    @Column(name = "id_case")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @Column(name = "number_of_tries")
    private int numberOfTries;
    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
