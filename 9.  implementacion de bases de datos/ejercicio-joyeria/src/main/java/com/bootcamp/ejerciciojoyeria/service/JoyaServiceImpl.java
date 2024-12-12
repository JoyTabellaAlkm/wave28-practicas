package com.bootcamp.ejerciciojoyeria.service;

import com.bootcamp.ejerciciojoyeria.dto.JoyaDto;
import com.bootcamp.ejerciciojoyeria.exception.NotFoundException;
import com.bootcamp.ejerciciojoyeria.model.Joya;
import com.bootcamp.ejerciciojoyeria.repository.IJoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService{
    @Autowired
    IJoyaRepository joyaRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public Long createJewel(JoyaDto joyaDto) {
        Joya joyaEntity = mapper.convertValue(joyaDto, Joya.class);
        Joya joyaGuardada = joyaRepository.save(joyaEntity);
        return joyaGuardada.getId();
    }

    @Override
    public List<JoyaDto> getAllJewels() {
        List<Joya> joyas = joyaRepository.findAll();
        if(joyas.isEmpty()) {
            throw new NotFoundException("Aun no se han creado joyas en el inventario");
        }
        return joyas.stream().map(j -> mapper.convertValue(j, JoyaDto.class)).toList();
    }

    @Override
    public void deleteJewel(Long id) {

    }

    @Override
    public JoyaDto updateJewel(Long idUpdate, JoyaDto joyaDto) {
        return null;
    }
}
