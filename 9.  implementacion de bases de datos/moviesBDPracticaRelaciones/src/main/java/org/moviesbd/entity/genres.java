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
@Table(name="genres")
public class genres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(length = 100)
    private String name;

    private int ranking;

    @Column(length = 1)
    private int active;

    @OneToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<movies> movies;

    @OneToMany(mappedBy = "genres", fetch = FetchType.LAZY)
    private Set<series> series;
}
