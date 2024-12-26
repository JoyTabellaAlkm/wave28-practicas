package com.bootcamp.ejerciciojoyeria.service;

import com.bootcamp.ejerciciojoyeria.dto.RequestJoyaDto;
import com.bootcamp.ejerciciojoyeria.dto.ResponseJoyaDto;
import com.bootcamp.ejerciciojoyeria.dto.ResponsePostDto;
import com.bootcamp.ejerciciojoyeria.dto.UpdateJoyaDto;
import com.bootcamp.ejerciciojoyeria.exception.NotFoundException;
import com.bootcamp.ejerciciojoyeria.model.Joya;
import com.bootcamp.ejerciciojoyeria.repository.IJoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaServiceImpl implements IJoyaService{
    @Autowired
    IJoyaRepository joyaRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public ResponsePostDto createJewel(RequestJoyaDto requestJoyaDto) {
        Joya joyaEntity = mapper.convertValue(requestJoyaDto, Joya.class);
        Joya joyaGuardada = joyaRepository.save(joyaEntity);
        return new ResponsePostDto(joyaGuardada.getId());
    }

    @Override
    public List<ResponseJoyaDto> getAllJewels() {
        List<Joya> joyas = joyaRepository.findAll();
        if(joyas.isEmpty()) {
            throw new NotFoundException("Aun no se han creado joyas en el inventario");
        }
        return joyas.stream().filter(Joya::isVentaONo).map(j -> mapper.convertValue(j, ResponseJoyaDto.class)).toList();
    }

    @Override
    public boolean deleteJewel(Long id) {
       if(!existejoya(id)) {
           throw new NotFoundException("No se encontró la joya a eliminar");
       }

       joyaRepository.deleteById(id);

        return true;
    }

    @Override
    public UpdateJoyaDto updateJewel(Long id, UpdateJoyaDto updateJoyaDto) {
        if(!existejoya(id)) {
            throw new NotFoundException("La joya a actualizar no existe");
        }
        Joya joyaEntity = mapper.convertValue(updateJoyaDto, Joya.class);
        joyaEntity.setId(id);
        Joya uptatedEntity = joyaRepository.save(joyaEntity);

        return mapper.convertValue(uptatedEntity, UpdateJoyaDto.class);
    }

    private boolean existejoya(Long id) {
        Optional<Joya> joya = joyaRepository.findById(id);
        return joya.map(Joya::isVentaONo).orElse(false);
    }
}
