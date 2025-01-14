package com.example.segurosdeautos.service.impl;

import com.example.segurosdeautos.dto.request.SiniestroRequestDto;
import com.example.segurosdeautos.dto.response.SiniestroResponseDto;
import com.example.segurosdeautos.model.Siniestro;
import com.example.segurosdeautos.repository.ISiniestroRepository;
import com.example.segurosdeautos.service.ISiniestroService;
import com.example.segurosdeautos.util.Utility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiniestroService implements ISiniestroService {

    private final ISiniestroRepository siniestroRepository;

    public SiniestroService(ISiniestroRepository siniestroRepository){
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public SiniestroResponseDto crearSiniestro(SiniestroRequestDto siniestro) {
        Siniestro siniestroEntity = Utility.getModelMapper()
                .map(siniestro, Siniestro.class);
        return Utility.getModelMapper()
                .map(siniestroRepository.save(siniestroEntity), SiniestroResponseDto.class);
    }

    @Override
    public List<SiniestroResponseDto> obtenerTodosLosSiniestros() {
        List<Siniestro> siniestroList = siniestroRepository.findAll();

        return siniestroList.stream()
                .map(siniestro -> Utility.getModelMapper()
                        .map(siniestro, SiniestroResponseDto.class))
                .toList();
    }

    @Override
    public SiniestroResponseDto obtenerSiniestroPorId(Long id) {
        Optional<Siniestro> siniestroEncontrado = siniestroRepository.findById(id);
        return siniestroEncontrado.map(siniestro -> Utility.getModelMapper()
                .map(siniestro, SiniestroResponseDto.class)).orElse(null);
    }
}
