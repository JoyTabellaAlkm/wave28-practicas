package com.example.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "series")
public class Serie {
    @Id
    int id;
    @Column(name = "created_at")
    LocalDate createdAt;
    @Column(name = "updated_at")
    LocalDate updatedAt;
    String title;
    @Column(name = "release_date")
    LocalDate releaseDate;
    @Column(name = "end_date")
    LocalDate endDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genre genre;
}
