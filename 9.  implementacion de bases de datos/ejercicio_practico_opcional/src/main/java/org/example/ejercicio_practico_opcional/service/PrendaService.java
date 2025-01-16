package org.example.ejercicio_practico_opcional.service;

import org.example.ejercicio_practico_opcional.dto.PrendaDTO;
import org.example.ejercicio_practico_opcional.exception.PrendaNotFoundException;
import org.example.ejercicio_practico_opcional.model.Prenda;
import org.example.ejercicio_practico_opcional.repository.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaService {

    @Autowired
    PrendaRepository prendaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PrendaDTO> findAll() {
        List<Prenda> prendas = prendaRepository.findAll();
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .collect(Collectors.toList());
    }

    public PrendaDTO addPrenda(PrendaDTO prendaDTO) {
        Prenda prenda = modelMapper.map(prendaDTO, Prenda.class);
        Prenda savedPrenda = prendaRepository.save(prenda);
        return modelMapper.map(savedPrenda, PrendaDTO.class);
    }

    public PrendaDTO findByCodigo(Long codigo) {
        Prenda prenda = prendaRepository.findById(codigo).orElseThrow(() -> new PrendaNotFoundException(codigo));
        return modelMapper.map(prenda, PrendaDTO.class);
    }

    public PrendaDTO updatePrenda(Long codigo, PrendaDTO prendaDTO) {
        Prenda prendaExistente = prendaRepository.findById(codigo)
                .orElseThrow(() -> new PrendaNotFoundException(codigo));

        modelMapper.map(prendaDTO, prendaExistente);

        Prenda updatedPrenda = prendaRepository.save(prendaExistente);

        return modelMapper.map(updatedPrenda, PrendaDTO.class);
    }

    public void deletePrenda(Long codigo) {
        Prenda prenda = prendaRepository.findById(codigo)
                .orElseThrow(() -> new PrendaNotFoundException(codigo)); // Lanzar excepción si no se encuentra

        prendaRepository.delete(prenda); // Eliminar la prenda
    }

    public List<PrendaDTO> findByTalle(String talle) {
        List<Prenda> prendas = prendaRepository.findByTalle(talle);
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PrendaDTO> findByName(String name) {
        List<Prenda> prendas = prendaRepository.findByNameContainingIgnoreCase(name);
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .collect(Collectors.toList());
    }
}
