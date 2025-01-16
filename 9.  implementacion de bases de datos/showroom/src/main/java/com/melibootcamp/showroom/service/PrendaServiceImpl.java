package com.melibootcamp.showroom.service;



import com.melibootcamp.showroom.dto.PrendaDto;
import com.melibootcamp.showroom.entity.Prenda;
import com.melibootcamp.showroom.repository.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements PrendaService {

    private final PrendaRepository prendaRepository;
    private final ModelMapper modelMapper;

    public PrendaServiceImpl(PrendaRepository prendaRepository){
        this.modelMapper = new ModelMapper();
        this.prendaRepository = prendaRepository;
    }

    @Override
    public List<PrendaDto> getPrendas() {
        List<PrendaDto> toReturn = prendaRepository.findAll().stream()
                .map(x -> modelMapper.map(x, PrendaDto.class))
                .toList();
        return toReturn;
    }

    @Override
    public PrendaDto getPrendaById(long id) {
        PrendaDto toReturn = modelMapper.map(prendaRepository.findById(id).orElse(null),PrendaDto.class);
        return toReturn;
    }

    @Override
    public List<PrendaDto> getPrendaBySize(String talle) {
        List<PrendaDto> toReturn = prendaRepository.findByTalle(talle).stream()
                .map(x -> modelMapper.map(x, PrendaDto.class))
                .toList();
        return toReturn;
    }

    @Override
    public List<PrendaDto> getPrendaByPatternOnTitle(String pattern) {
        List<PrendaDto> toReturn = prendaRepository.findByPatternOnTitle(pattern).stream()
                .map(x -> modelMapper.map(x, PrendaDto.class))
                .toList();
        return toReturn;
    }


    @Override
    public boolean savePrenda(PrendaDto prenda) {
        try{
            Prenda toSave = modelMapper.map(prenda, Prenda.class);
            prendaRepository.save(toSave);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deletePrenda(long id) {
        try{
            prendaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }


    @Override
    public boolean updatePrenda(long id, PrendaDto prenda) {

        if (!prendaRepository.existsById(id)){
            return false;
        }

        prenda.setId(id);
        Prenda toUpdate = modelMapper.map(prenda, Prenda.class);
        prendaRepository.save(toUpdate);
        return true;
    }


}
