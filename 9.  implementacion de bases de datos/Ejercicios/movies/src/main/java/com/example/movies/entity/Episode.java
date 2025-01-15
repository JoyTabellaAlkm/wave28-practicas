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
@Table(name = "episodes")
public class Episode {
    @Id
    int id;
    @Column(name = "created_at")
    LocalDate createdAt;
    @Column(name = "updated_at")
    LocalDate updatedAt;
    String title;
    int number;
    @Column(name = "release_date")
    LocalDate releaseDate;
    double rating;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "season_id")
    Season season;
}
