package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.PrendaDto;
import com.mercadolibre.showroom.entity.Prenda;
import com.mercadolibre.showroom.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService implements IPrendaService {

    private final IPrendaRepository prendaRepository;
    ModelMapper modelMapper = new ModelMapper();

    public PrendaService(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    @Override
    public List<PrendaDto> getPrendas() {
        return prendaRepository.findAll().stream().map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }

    @Override
    public Boolean createPrenda(PrendaDto prendaDto) {
        prendaRepository.save(modelMapper.map(prendaDto, Prenda.class));
        return true;
    }

    @Override
    public PrendaDto getPrendaByCode(Long code) {
        return prendaRepository.findById(code).map(prenda -> modelMapper.map(prenda, PrendaDto.class)).orElse(null);
    }

    @Override
    public Boolean updatePrenda(Long code, PrendaDto prendaDto) {
        if(prendaRepository.existsById(code)) {
            Prenda p = modelMapper.map(prendaDto, Prenda.class);
            p.setCodigo(code);
            prendaRepository.save(p);

            return true;
        }
        return false;
    }

    @Override
    public Boolean deletePrenda(Long code) {
        if(prendaRepository.existsById(code)) {
            prendaRepository.deleteById(code);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<PrendaDto> getPrendasBySize(String size) {
        return prendaRepository.findByTalle(size).stream().map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }

    @Override
    public List<PrendaDto> getPrendasByName(String name) {
        return prendaRepository.findByNombreContainingIgnoreCase(name).stream().map(prenda -> modelMapper.map(prenda, PrendaDto.class)).toList();
    }
}
