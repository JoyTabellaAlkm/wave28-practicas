package com.ejercicio.QATester.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long idCase;

    private String descripcion;
    private boolean tested;
    private boolean passed;

    @Column(name = "number_or_tries")
    private int numberOfTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
