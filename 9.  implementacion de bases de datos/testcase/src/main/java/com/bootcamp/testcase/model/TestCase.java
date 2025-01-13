package com.bootcamp.testcase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    @JsonProperty("id_case")
    Long idCase;
    @JsonProperty("description")
    String description;
    @JsonProperty("tested")
    Boolean tested;
    @JsonProperty("passed")
    Boolean passed;
    @JsonProperty("number_of_tries")
    @Column(name = "number_of_tries")
    int numberOfTries;
    @JsonProperty("last_update")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "last_update")
    LocalDate lastUpdate;
}
