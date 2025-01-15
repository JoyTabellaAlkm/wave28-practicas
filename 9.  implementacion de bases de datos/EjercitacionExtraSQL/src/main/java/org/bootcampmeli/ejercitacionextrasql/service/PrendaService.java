package org.bootcampmeli.ejercitacionextrasql.service;

import org.bootcampmeli.ejercitacionextrasql.dto.MessageDto;
import org.bootcampmeli.ejercitacionextrasql.dto.PrendaDto;
import org.bootcampmeli.ejercitacionextrasql.model.Prenda;
import org.bootcampmeli.ejercitacionextrasql.repository.PrendaRepository;
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
        List<Prenda> prendas =  prendaRepository.findAll();
        return prendas.stream().map(p -> modelMapper.map(p, PrendaDto.class)).collect(Collectors.toList());
    }

    @Override
    public PrendaDto getPrendaByCode(Long codigo){
        Prenda prenda = prendaRepository.findByCodigo(codigo);
        return modelMapper.map(prenda, PrendaDto.class);
    }

    @Override
    public PrendaDto updatePrenda(Long codigo, PrendaDto prenda){
        Prenda prendaExistente = prendaRepository.findByCodigo(codigo);
        if(prendaExistente != null){

            prenda.setCodigo(codigo);
            Prenda prendaGuardada = prendaRepository.save(modelMapper.map(prenda, Prenda.class));
            return modelMapper.map(prendaGuardada, PrendaDto.class);

        }
        return null;
    }

    @Override
    public MessageDto deletePrenda(Long codigo){
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
        List<Prenda> prendas = prendaRepository.findAllByNombreIsContainingIgnoreCase(name);
        return prendas.stream().map(p -> modelMapper.map(p, PrendaDto.class)).collect(Collectors.toList());

    }




}
