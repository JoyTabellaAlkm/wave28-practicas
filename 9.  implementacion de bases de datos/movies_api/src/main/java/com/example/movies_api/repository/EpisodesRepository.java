package com.example.movies_api.repository;

import com.example.movies_api.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodesRepository extends JpaRepository<Episode, Integer> {
}
