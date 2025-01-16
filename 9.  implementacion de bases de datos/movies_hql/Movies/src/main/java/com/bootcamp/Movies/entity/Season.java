package com.bootcamp.Movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "title")
    private String title;
    @Column(name = "number")
    private Integer number;
    @Column(name = "release_date")
    private Timestamp releaseDate;
    @Column(name = "end_date")
    private Timestamp endDate;
    @ManyToOne
    @JoinColumn(name="serie_id")
    Serie serie;
}
