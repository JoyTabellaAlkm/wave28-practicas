package com.bootcamp.Movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "title")
    private String title;
    @Column(name = "release_date")
    private Timestamp releaseDate;
    @Column(name = "end_date")
    private Timestamp endDate;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @OneToMany(mappedBy = "serie")
    private Set<Season> seasons;
}
