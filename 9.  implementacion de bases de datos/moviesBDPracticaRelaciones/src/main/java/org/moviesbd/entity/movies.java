package org.moviesbd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.cglib.core.Local;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(length = 500)
    private String title;

    private float raiting;

    private int awards;

    @Column(name = "released_date")
    private LocalDate releaseDate;

    private int length;

    @ManyToOne
    @JoinColumn(name="genre_id", nullable = false)
    private genres genres;

    @OneToMany(mappedBy = "movie")
    private Set<actorMovie> actorMovies;

    @OneToMany(mappedBy = "movie")
    private Set<actors> actors;
}
