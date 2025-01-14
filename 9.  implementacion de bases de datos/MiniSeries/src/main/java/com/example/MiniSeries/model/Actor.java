package com.example.MiniSeries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String fullName;
    @Column
    private int age;

    @ManyToMany
    @JoinTable(
            name="actor_miniserie",
            joinColumns = @JoinColumn (name = "actor_id"),
            inverseJoinColumns = @JoinColumn (name = "miniserie_id")
    )
    private Set<MiniSerie> miniSeries;

}
