package com.ar.mercadolibre.obrasliterarias.service;

import com.ar.mercadolibre.obrasliterarias.dto.ObraLiterariaDTO;
import com.ar.mercadolibre.obrasliterarias.entity.ObraLiteraria;
import com.ar.mercadolibre.obrasliterarias.repository.IObraLiterariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService{

    private final IObraLiterariaRepository obraLiterariaRepository;
    private final ModelMapper mapper;


    public ObraLiterariaServiceImpl(IObraLiterariaRepository obraLiterariaRepository, ModelMapper mapper) {
        this.obraLiterariaRepository = obraLiterariaRepository;
        this.mapper = mapper;
    }


    @Override
    public ObraLiterariaDTO create(ObraLiterariaDTO obraLiterariaDTO) {
        ObraLiteraria obraLiterariaAGuardar = mapper.map(obraLiterariaDTO, ObraLiteraria.class);
        ObraLiteraria obraLiterariaGuardada = obraLiterariaRepository.save(obraLiterariaAGuardar);

        return mapper.map(obraLiterariaGuardada, ObraLiterariaDTO.class);
    }

    @Override
    public List<ObraLiterariaDTO> encontrarPorNombre(String nombre) {
        Pageable pageable = PageRequest.of(0, 50);
        Page<ObraLiteraria> obraLiterarias = obraLiterariaRepository.findBynombreContainingIgnoreCase(nombre, pageable);

        return obraLiterarias.stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> encontrarTodasLasObras() {
        Iterable<ObraLiteraria> obraLiterarias = obraLiterariaRepository.findAll();
        List<ObraLiterariaDTO> obraLiterariaDTOs = new ArrayList<>();

        for (ObraLiteraria obraLiteraria : obraLiterarias) {
            obraLiterariaDTOs.add(mapper.map(obraLiteraria, ObraLiterariaDTO.class));
        }

        return obraLiterariaDTOs;
    }

    @Override
    public List<ObraLiterariaDTO> encontrarPorAutor(String autor) {
        Pageable pageable = PageRequest.of(0, 50);
        Page<ObraLiteraria> obraLiterarias = obraLiterariaRepository.findByAutorContainingIgnoreCase(autor, pageable);

        return obraLiterarias.stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> encontrarCincoObrasConMasPaginas() {
        List<ObraLiteraria> obraLiterarias = obraLiterariaRepository.findTop5ByOrderByCantidadDePaginasDesc();

        return obraLiterarias.stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> encontrarObrasAntesDeAnio(Integer anio) {
        Pageable pageable = PageRequest.of(0, 50);
        Page<ObraLiteraria> obraLiterarias = obraLiterariaRepository.findByAnioPrimeraPublicacionBefore(anio - 1, pageable);

        return obraLiterarias.stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> encontrarPorEditorial(String editorial) {
        Pageable pageable = PageRequest.of(0, 50);
        Page<ObraLiteraria> obraLiterarias = obraLiterariaRepository.findByEditorial(editorial, pageable);

        return obraLiterarias.stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDTO.class)).toList();
    }
}
