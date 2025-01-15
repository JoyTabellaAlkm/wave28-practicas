package com.bootcamp.movies_api.service.impl;

import com.bootcamp.movies_api.dto.SerieDTO;
import com.bootcamp.movies_api.repository.SerieRepository;
import com.bootcamp.movies_api.service.SerieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {

    ModelMapper modelMapper;
    SerieRepository serieRepository;

    @Autowired
    public SerieServiceImpl(ModelMapper modelMapper, SerieRepository serieRepository) {
        this.modelMapper = modelMapper;
        this.serieRepository = serieRepository;
    }

    @Override
    public List<SerieDTO> findAll() {
        return serieRepository.findAll()
                .stream()
                .map(s -> modelMapper.map(s, SerieDTO.class))
                .toList();
    }

    @Override
    public List<SerieDTO> findAllBySeasonsSizeGreaterThan(Integer num) {
        return serieRepository.findAllBySeasonsSizeGreaterThan(num)
                .stream()
                .map(s -> modelMapper.map(s, SerieDTO.class))
                .toList();
    }
}
