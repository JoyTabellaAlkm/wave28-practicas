package com.mercadolibre.showroom.service.impl;

import com.mercadolibre.showroom.dto.PrendaDto;
import com.mercadolibre.showroom.model.Prenda;
import com.mercadolibre.showroom.repository.IPrendaRepository;
import com.mercadolibre.showroom.service.IPrendaService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService implements IPrendaService {
    private final ModelMapper mapper;

    private final IPrendaRepository prendaRepository;

    public PrendaService(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
        this.mapper= new ModelMapper();
    }

    @Override
    public Integer crearNuevaPrenda(PrendaDto prendaDto) {
        return prendaRepository.save(mapper.map(prendaDto, Prenda.class)).getCodigo();
    }

    @Override
    public List<PrendaDto> obtenerPrendas() {
        return prendaRepository.findAll()
                .stream().map(prenda ->
                        mapper.map(prenda,PrendaDto.class))
                .toList();
    }

    @Override
    public PrendaDto obtenerPrenda(Integer codigo) {
        return mapper.map(prendaRepository.findById(codigo),PrendaDto.class);
    }

    @Override
    public PrendaDto actualizarPrenda(Integer codigo, PrendaDto prendaDto) {
        Prenda prenda = prendaRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Prenda con código " + codigo + " no encontrada."));;
        mapper.map(prendaDto,prenda);
        return mapper.map(prendaRepository.save(prenda),PrendaDto.class);
    }

    @Override
    public void eliminarPrenda(Integer codigo) {
        prendaRepository.deleteById(codigo);
    }

    @Override
    public List<PrendaDto> buscarPrendasXTalle(String talle) {
        return prendaRepository.findAllByTalle(talle)
                .stream().map(prenda ->
                        mapper.map(prenda,PrendaDto.class))
                .toList();
    }

    @Override
    public List<PrendaDto> buscarPrendasXNombre(String nombre) {
        return prendaRepository.findAllByNombreContainingIgnoreCase(nombre)
                .stream().map(prenda ->
                        mapper.map(prenda,PrendaDto.class))
                .toList();
    }
}
