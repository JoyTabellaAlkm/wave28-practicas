package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.PrendaDTO;
import com.bootcamp.showroom.entity.Prenda;
import com.bootcamp.showroom.repository.PrendaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements IPrendaService {

    private final PrendaRepository prendaRepository;
    private ModelMapper modelMapper= new ModelMapper();

    public PrendaServiceImpl(PrendaRepository prendaRepository, ObjectMapper objectMapper) {
        this.prendaRepository = prendaRepository;
    }


    @Override
    public List<PrendaDTO> getPrendas() {
        List<Prenda> listAll = prendaRepository.findAll();
        return listAll.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .toList();
    }

    @Override
    public List<PrendaDTO> getPrendaByCode(String codigo) {
        List<Prenda> prendasByCode = prendaRepository.findAllByCodigo(codigo);

        return prendasByCode.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .toList();
    }

    @Override
    public List<PrendaDTO> getPrendaBySize(String talle) {
        List<Prenda> prendasByTalle = prendaRepository.findAllByTalle(talle);

        return prendasByTalle.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .toList();
    }

    @Override
    public List<PrendaDTO> getPrendaByName(String nombre) {
        List<Prenda> prendasByNombre = prendaRepository.findAllByNombre(nombre);

        return prendasByNombre.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .toList();
    }

}
