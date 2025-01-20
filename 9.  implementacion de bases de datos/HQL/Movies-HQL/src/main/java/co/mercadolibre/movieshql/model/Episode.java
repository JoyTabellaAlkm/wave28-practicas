package co.mercadolibre.movieshql.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    private String title;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ManyToMany
    @JoinTable(name = "actor_episode",
            joinColumns = @JoinColumn(name="episode_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id")
    )
    private List<Actor> actors;
}
