package com.demo.demo.service;

import com.demo.demo.dto.PrendaDTO;
import com.demo.demo.model.Prenda;
import com.demo.demo.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService implements IPrendaService {
    private final IPrendaRepository repository;
    private final ModelMapper mapper;

    public PrendaService(IPrendaRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PrendaDTO save(PrendaDTO prenda) {
        Prenda prendaToSave = mapper.map(prenda, Prenda.class);
        Prenda savedPrenda = repository.save(prendaToSave);
        return mapper.map(savedPrenda, PrendaDTO.class);
    }

    @Override
    public List<PrendaDTO> findAll() {
        List<Prenda> prendas = repository.findAll();
        return prendas.stream().map(p -> mapper.map(p, PrendaDTO.class)).toList();
    }

    @Override
    public PrendaDTO findById(String id) {
        Prenda prenda = repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        return mapper.map(prenda, PrendaDTO.class);
    }

    @Override
    public PrendaDTO delete(String id) {
        PrendaDTO prenda = this.findById(id);
        repository.deleteById(id);
        return prenda;
    }

    @Override
    public List<PrendaDTO> findAllByName(String name) {
        return repository.findAllByName(name)
                .stream()
                .map(p -> mapper.map(p, PrendaDTO.class))
                .toList();
    }
}
