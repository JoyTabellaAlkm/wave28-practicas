package org.moviesbd.repository;

import org.moviesbd.entity.genres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iMoviesRepository extends JpaRepository<genres, Integer> {
    public List<genres> findAllByMoviesIsNotEmpty();
}
