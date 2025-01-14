package com.mercadolibre.testers.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test_case")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long idCase;

    @Column
    private String description;

    @Column
    private Boolean tested;

    @Column
    private Boolean passed;

    @Column(name = "number_of_tries")
    private int numberOfTries;

    @Column(name = "last_update")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate lastUpdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;
}
