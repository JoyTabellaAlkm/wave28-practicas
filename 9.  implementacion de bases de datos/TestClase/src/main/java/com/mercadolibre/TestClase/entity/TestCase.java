package com.mercadolibre.TestClase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "testcases")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_case;
    @Column()
    String description;
    @Column()
    Boolean tested;
    @Column()
    Boolean passed;
    @Column()
    int number_of_tries;
    @Column()
    String last_update;
}
