package com.mercadolibre.ejerciciohql.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Timestamp;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    Long id;

    @Column(length = 100, nullable = false)
    String name;

    @Column(nullable = false, unique = true)
    Integer ranking;

    @Column(nullable = false, columnDefinition = "Tinyint(1) default 1")
    Boolean active;

    @OneToMany(mappedBy = "genre")
    Set<Movie> movies;

    @OneToMany(mappedBy = "genre")
    Set<Series> series;

    Timestamp createdAt;
    Timestamp updatedAt;
}
