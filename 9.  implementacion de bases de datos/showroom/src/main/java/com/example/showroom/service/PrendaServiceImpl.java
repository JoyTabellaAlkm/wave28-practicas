package com.example.showroom.service;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.entity.Prenda;
import com.example.showroom.repository.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrendaServiceImpl implements PrendaService{

    PrendaRepository prendaRepository;
    private final ModelMapper mapper;
    public PrendaServiceImpl(PrendaRepository prendaRepository){
        this.prendaRepository = prendaRepository;
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
    }

    @Override
    public Long postPrenda(PrendaDto prendaDto) {
        Prenda prenda = mapper.map(prendaDto,Prenda.class);
        prendaRepository.save(prenda);
        return prenda.getCodigo();
    }

    @Override
    public List<PrendaDto> getPrendas() {
        return prendaRepository.findAll().stream()
                .map(m->mapper.map(m,PrendaDto.class))
                .toList();
    }

    @Override
    public PrendaDto findPrendaCode(Long code) {
        return mapper.map(prendaRepository.findByCodigo(code),PrendaDto.class);
    }

    @Override
    public Long putPrenda(Long code, PrendaDto prendaDto) {
        Prenda prenda = prendaRepository.findByCodigo(code);
        mapper.map(prendaDto,prenda);
        prendaRepository.save(prenda);
        return code;
    }

    @Override
    public Long deletePrenda(Long code) {
        prendaRepository.deleteByCodigo(code);
        return code;
    }

    @Override
    public List<PrendaDto> findPrendasNombre(String nombre) {
        return prendaRepository.findByNombreContainingIgnoreCase(nombre).stream()
                .map(m->mapper.map(m,PrendaDto.class))
                .toList();
    }

    @Override
    public List<PrendaDto> findPrendasTalle(String talle) {
        return prendaRepository.findByTalle(talle).stream()
                .map(m->mapper.map(m,PrendaDto.class))
                .toList();
    }
}
