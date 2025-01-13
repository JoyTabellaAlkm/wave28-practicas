package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.req.JoyaCreationReqDto;
import com.bootcamp.joyeria.dto.res.JoyaGetDto;
import com.bootcamp.joyeria.dto.req.JoyaUpdateReqDto;
import com.bootcamp.joyeria.dto.res.JoyaCreationResDto;
import com.bootcamp.joyeria.dto.res.JoyaUpdateResDto;
import com.bootcamp.joyeria.exception.NotFoundException;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.JoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaServiceImpl implements JoyaService {

    @Autowired
    private JoyaRepository joyaRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public JoyaCreationResDto create(JoyaCreationReqDto joyaDto) {
        Joya nueva = joyaRepository.save(mapper.convertValue(joyaDto, Joya.class));
        return mapper.convertValue(nueva, JoyaCreationResDto.class);
    }

    @Override
    public List<JoyaGetDto> getAll() {
        return joyaRepository.findAll().stream()
                .filter(Joya::getVentaONo)
                .map(j -> mapper.convertValue(j, JoyaGetDto.class))
                .toList();
    }

    @Override
    public void delete(Long id) {
        var joya = joyaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        joya.setVentaONo(false);
        joyaRepository.save(joya);
    }

    @Override
    public JoyaUpdateResDto update(Long id, JoyaUpdateReqDto joyaDto) {
        var joya = joyaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        joya.setNombre(joyaDto.getNombre());
        joya.setPeso(joyaDto.getPeso());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPoseePiedra(joyaDto.getPoseePiedra());
        joya.setVentaONo(joyaDto.getVentaONo());
        joya = joyaRepository.save(joya);
        return mapper.convertValue(joya, JoyaUpdateResDto.class);
    }
}
