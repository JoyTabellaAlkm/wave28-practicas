package com.example.testcasesapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long idCase;

    @Column
    private String description;

    @Column
    private Boolean tested;

    @Column
    private Boolean passed;

    @Column
    private Integer numberOfTries;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate lastUpdate;
}
