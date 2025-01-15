package com.bootcamp.miniseries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "miniserie_id")
    Long id;
    String name;
    Double rating;
    Integer amount_of_awards;
    @OneToMany(mappedBy = "miniSerie", cascade = CascadeType.ALL)
    Set<Award> awardsSet;
}
