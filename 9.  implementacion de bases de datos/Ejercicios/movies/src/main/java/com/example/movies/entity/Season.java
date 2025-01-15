package com.example.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "seasons")
public class Season {
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
    @Column(name = "end_date")
    LocalDate endDate;
    @JsonIgnore
    @OneToMany(mappedBy = "season")
    List<Episode> episodes;
}
