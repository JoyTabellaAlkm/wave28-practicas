package com.mercadolibre.movies.service.impl;

import com.mercadolibre.movies.dto.EpisodeDto;
import com.mercadolibre.movies.repository.IEpisodeRepository;
import com.mercadolibre.movies.service.IEpisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService {
    @Autowired
    IEpisodeRepository episodeRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<EpisodeDto> obtenerEpisodiosPorActor(String nombre, String apellido) {
        return episodeRepository.findEpisodesByActorEpisodes(nombre,apellido)
                .stream().map(ep->modelMapper.map(ep,EpisodeDto.class))
                .toList();
    }
}
