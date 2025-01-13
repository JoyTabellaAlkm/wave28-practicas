package com.mercadolibre.joyeria.service.impl;

import com.mercadolibre.joyeria.dto.JoyaDto;
import com.mercadolibre.joyeria.model.Joya;
import com.mercadolibre.joyeria.repository.IJoyeriaRepository;
import com.mercadolibre.joyeria.service.IJoyeriaService;
import com.mercadolibre.joyeria.utils.mapper.JoyaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaServiceImpl implements IJoyeriaService {
    @Autowired
    IJoyeriaRepository joyeriaRepository;

    @Override
    public List<JoyaDto> obtenerJoyas() {
        return joyeriaRepository.findAll().stream().filter(Joya::isVentaONo)
                .map(JoyaMapper::toJoyaDto).toList();
    }

    @Override
    public Long guardaJoya(JoyaDto joyaDto) {
        Joya joya = joyeriaRepository.save(JoyaMapper.toJoya(joyaDto));
        return joya.getNroIdentificatorio();
    }

    @Override
    public void eliminarJoya(Long nroIdentificador) {
        Joya joya = joyeriaRepository.getById(nroIdentificador);
        joya.setVentaONo(false);
        joyeriaRepository.save(joya);
    }

    @Override
    public JoyaDto buscarJoya(Long nroIdentificador) {
        return JoyaMapper.toJoyaDto(joyeriaRepository.getById(nroIdentificador));
    }

    @Override
    public JoyaDto actualizarJoya(Long nroIdentificador, JoyaDto joyaDto) {
        Joya joya = joyeriaRepository.getById(nroIdentificador);
        joya.setNombre(joyaDto.getNombre());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setPeso(joyaDto.getPeso());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPoseePiedra(joyaDto.isPoseePiedra());
        joya.setVentaONo(joyaDto.isVentaONo());
        return JoyaMapper.toJoyaDto(joyeriaRepository.save(joya));
    }
}
