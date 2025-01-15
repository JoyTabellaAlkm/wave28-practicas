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
@Table(name = "actor_movie")
public class ActorMovie {
    @Id
    int id;
    @Column(name = "created_at")
    LocalDate createdAt;
    @Column(name = "updated_at")
    LocalDate updatedAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "actor_id")
    Actor actor;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;
}
