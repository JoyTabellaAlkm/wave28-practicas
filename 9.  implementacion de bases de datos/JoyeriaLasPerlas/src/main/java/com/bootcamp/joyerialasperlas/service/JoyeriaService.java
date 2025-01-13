package com.bootcamp.joyerialasperlas.service;

import com.bootcamp.joyerialasperlas.dto.request.CreateJoyaDTO;
import com.bootcamp.joyerialasperlas.dto.response.JoyaDTO;
import com.bootcamp.joyerialasperlas.dto.response.ResponseDTO;
import com.bootcamp.joyerialasperlas.model.Joya;
import com.bootcamp.joyerialasperlas.repository.IJoyeriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaService implements IJoyeriaService {
    private final IJoyeriaRepository joyeriaRepository;

    public JoyeriaService(IJoyeriaRepository joyeriaRepository) {
        this.joyeriaRepository = joyeriaRepository;
    }

    @Override
    public ResponseDTO agregarJoya(CreateJoyaDTO createJoyaDTO) {
        Joya joya = new Joya();
        joya.setNombre(createJoyaDTO.getNombre());
        joya.setMaterial(createJoyaDTO.getMaterial());
        joya.setPeso(createJoyaDTO.getPeso());
        joya.setParticularidad(createJoyaDTO.getParticularidad());
        joya.setPoseePiedra(createJoyaDTO.isPoseePiedra());
        joya.setVentaONo(createJoyaDTO.isVentaONo());

        joyeriaRepository.save(joya);
        return new ResponseDTO("Joya con número identificatorio " + joya.getNroIdentificatorio() + " creada exitosamente.");
    }

    @Override
    public List<JoyaDTO> obtenerJoyas() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Joya> joyas = joyeriaRepository.findAll();

        return joyas
                .stream()
                .map(joya -> objectMapper.convertValue(joya, JoyaDTO.class))
                .toList();
    }
}
