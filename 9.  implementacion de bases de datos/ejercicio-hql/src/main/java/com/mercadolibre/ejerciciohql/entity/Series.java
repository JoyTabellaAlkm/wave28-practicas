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
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    Long id;

    @Column(length = 500, nullable = false)
    String title;

    @Column(nullable = false)
    LocalDateTime releaseDate;

    @Column(nullable = false)
    LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    Genre genre;

    @OneToMany(mappedBy = "series")
    Set<Season> seasons;

    Timestamp createdAt;
    Timestamp updatedAt;
}
