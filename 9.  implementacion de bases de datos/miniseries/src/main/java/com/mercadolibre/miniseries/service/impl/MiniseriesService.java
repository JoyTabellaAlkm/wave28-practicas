package com.mercadolibre.miniseries.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.miniseries.dto.request.MiniSerieDTO;
import com.mercadolibre.miniseries.dto.response.MiniSerieDTOResponse;
import com.mercadolibre.miniseries.entity.MiniSerie;
import com.mercadolibre.miniseries.repository.IMiniserieRepository;
import com.mercadolibre.miniseries.service.IMiniseriesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiniseriesService implements IMiniseriesService {
    private final IMiniserieRepository miniserieRepository;
    private final ObjectMapper objectMapper;

    public MiniseriesService(IMiniserieRepository miniserieRepository, ObjectMapper objectMapper) {
        this.miniserieRepository = miniserieRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<MiniSerie> getMiniSeries() {
        return miniserieRepository.findAll();
    }

    @Override
    public MiniSerieDTOResponse saveMiniSerie(MiniSerieDTO newMiniSerie) {
        MiniSerie miniSerieSaved = miniserieRepository.save(objectMapper.convertValue(newMiniSerie, MiniSerie.class));
        return objectMapper.convertValue(miniSerieSaved, MiniSerieDTOResponse.class);
    }

    @Override
    public void deleteMiniSerie(Long id) {
        miniserieRepository.deleteById(id);
    }

    @Override
    public MiniSerieDTOResponse findMiniserie(Long id) {
        try{
            Optional<MiniSerie> miniSerie = miniserieRepository.findById(id);
            if(miniSerie.isPresent()){
                return objectMapper.convertValue(miniSerie, MiniSerieDTOResponse.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
