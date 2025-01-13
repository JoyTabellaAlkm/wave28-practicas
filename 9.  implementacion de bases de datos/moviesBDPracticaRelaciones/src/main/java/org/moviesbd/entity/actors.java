package org.moviesbd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    private float rating;

    @OneToMany(mappedBy = "actor")
    private Set<actorMovie> actorMovies;

    @OneToMany(mappedBy = "actor")
    private Set<actorEpisode> actorEpisodes;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private movies movie;
}
