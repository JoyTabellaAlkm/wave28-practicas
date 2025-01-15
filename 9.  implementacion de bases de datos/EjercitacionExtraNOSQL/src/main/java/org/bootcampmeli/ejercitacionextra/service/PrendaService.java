package org.bootcampmeli.ejercitacionextra.service;


import org.bootcampmeli.ejercitacionextra.dto.MessageDto;
import org.bootcampmeli.ejercitacionextra.dto.PrendaDto;
import org.bootcampmeli.ejercitacionextra.model.Prenda;
import org.bootcampmeli.ejercitacionextra.repository.PrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaService implements IPrendaService {

    @Autowired
    private PrendaRepository prendaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PrendaDto addPrenda(PrendaDto prendaDto){

        Prenda prenda = modelMapper.map(prendaDto, Prenda.class);
        Prenda prendaGuardada = prendaRepository.save(prenda);
        return modelMapper.map(prendaGuardada, PrendaDto.class);

    }

    @Override
    public List<PrendaDto> getAllPrendas(){
        Page<Prenda> prendas = (Page<Prenda>) prendaRepository.findAll();
        return prendas.getContent().stream().map(p -> modelMapper.map(p, PrendaDto.class)).collect(Collectors.toList());
    }

    @Override
    public PrendaDto getPrendaByCode(String codigo){
        Prenda prenda = prendaRepository.findByCodigo(codigo);
        return modelMapper.map(prenda, PrendaDto.class);
    }

    @Override
    public PrendaDto updatePrenda(String codigo, PrendaDto prenda){
        Prenda prendaExistente = prendaRepository.findByCodigo(codigo);
        if(prendaExistente != null){

            Prenda prendaGuardada = prendaRepository.save(modelMapper.map(prenda, Prenda.class));
            return modelMapper.map(prendaGuardada, PrendaDto.class);

        }
        return null;
    }

    @Override
    public MessageDto deletePrenda(String codigo){
        Prenda prenda = prendaRepository.findByCodigo(codigo);
        if(prenda != null){
            prendaRepository.delete(prenda);
            return new MessageDto("Eliminado ok");
        }
        return new MessageDto("Prenda no encontrada");

    }

    @Override
    public List<PrendaDto> getBySize(String size){
        List<Prenda> prendas = prendaRepository.findAllByTalle(size);
        return prendas.stream().map(p -> modelMapper.map(p, PrendaDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<PrendaDto> getByName(String name){
        List<Prenda> prendas = prendaRepository.findAllByNombreCustom(name);
        return prendas.stream().map(p -> modelMapper.map(p, PrendaDto.class)).collect(Collectors.toList());
    }


}
