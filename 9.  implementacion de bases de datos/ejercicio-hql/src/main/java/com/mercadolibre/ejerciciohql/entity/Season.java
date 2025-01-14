package com.mercadolibre.ejerciciohql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    Long id;

    @Column(length = 500)
    String title;

    @Column(nullable = false, unique = true)
    Integer number;

    @Column(nullable = false)
    LocalDateTime releaseDate;

    @Column(nullable = false)
    LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    Series series;

    @OneToMany(mappedBy = "season")
    Set<Episode> episodes;

    Timestamp createdAt;
    Timestamp updatedAt;
}
