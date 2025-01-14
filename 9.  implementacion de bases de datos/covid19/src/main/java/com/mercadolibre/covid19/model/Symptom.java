package com.mercadolibre.covid19.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "symptoms")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    @Column(name = "level_of_severity")
    private Integer levelOfSeverity;
    @ManyToMany(mappedBy = "symptoms")
    @JsonIgnore
    private List<Person> people;
}
