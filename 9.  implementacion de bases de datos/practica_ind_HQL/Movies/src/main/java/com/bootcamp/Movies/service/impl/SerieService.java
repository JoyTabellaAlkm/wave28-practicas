package com.bootcamp.Movies.service.impl;

import com.bootcamp.Movies.dto.SerieSeasonsCountDto;
import com.bootcamp.Movies.repository.ISerieRepository;
import com.bootcamp.Movies.repository.projection.SerieSeasonsCountProjection;
import com.bootcamp.Movies.service.ISerieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class SerieService implements ISerieService {

    private final ISerieRepository serieRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public SerieService(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieSeasonsCountDto> seriesWithSeasonsNumberGreaterThan(Integer seasonsNumber) {
       List<SerieSeasonsCountProjection> projections = serieRepository.seriesWithSeasonsNumberGreaterThan(seasonsNumber);
       return projections.stream()
               .map(projection -> modelMapper.map(projection, SerieSeasonsCountDto.class))
               .toList();
    }
}
