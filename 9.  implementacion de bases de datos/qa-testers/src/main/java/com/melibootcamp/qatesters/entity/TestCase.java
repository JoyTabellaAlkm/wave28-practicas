package com.melibootcamp.qatesters.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    @Column(columnDefinition = "DATETIME")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate last_update;

    //Relaciones con otras entidades
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User assignedUser;

}
