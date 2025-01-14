package com.bootcamp.movies_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("genre_id")
    private Long id;
    @Column(name = "created_at")
    @JsonProperty("created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
    @Column(nullable = false)
    @JsonProperty("name")
    String name;
    @Column(nullable = false)
    @JsonProperty("ranking")
    Integer ranking;
    @Column(nullable = false)
    @JsonProperty("active")
    Boolean active;
}
