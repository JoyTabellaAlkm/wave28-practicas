package com.example.MiniSeries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "serie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Double rating;
    @Column
    private int amount_of_awards;

    @ManyToMany(mappedBy = "miniSeries")
    private Set<Actor> actors;

    @OneToMany(mappedBy = "miniSerie", cascade = CascadeType.ALL)
    private Set<Award> awards;
}
