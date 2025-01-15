package com.bootcamp.movies_api.service;

import com.bootcamp.movies_api.dto.SimpleEpisodeWithActorsDTO;
import com.bootcamp.movies_api.model.Episode;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeService {
    List<SimpleEpisodeWithActorsDTO> findAll();
    List<SimpleEpisodeWithActorsDTO> findAllByActor(Long actorID);
}
