package com.bootcamp.movies_api.service.impl;

import com.bootcamp.movies_api.dto.SimpleEpisodeWithActorsDTO;
import com.bootcamp.movies_api.model.Episode;
import com.bootcamp.movies_api.repository.EpisodeRepository;
import com.bootcamp.movies_api.service.EpisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    EpisodeRepository episodeRepository;
    ModelMapper modelMapper;

    @Autowired
    public EpisodeServiceImpl(EpisodeRepository episodeRepository, ModelMapper modelMapper) {
        this.episodeRepository = episodeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SimpleEpisodeWithActorsDTO> findAll() {
        return episodeRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, SimpleEpisodeWithActorsDTO.class))
                .toList();
    }

    @Override
    public List<SimpleEpisodeWithActorsDTO> findAllByActor(Long actorID) {
        return episodeRepository.findAllByActor(actorID)
                .stream()
                .map(e -> modelMapper.map(e, SimpleEpisodeWithActorsDTO.class))
                .toList();
    }
}
