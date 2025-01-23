package com.melibootcamp.sportsmen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Integer age;

    @ManyToMany(mappedBy = "sportsmen")

    @JsonProperty("sports_list")
    @JsonIgnore
    private List<Sport> sportsList;

}
