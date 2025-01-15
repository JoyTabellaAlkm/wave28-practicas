package com.bootcamp.movies_api.service;

import com.bootcamp.movies_api.dto.SerieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SerieService {
    List<SerieDTO> findAll();
    List<SerieDTO> findAllBySeasonsSizeGreaterThan(Integer num);
}
