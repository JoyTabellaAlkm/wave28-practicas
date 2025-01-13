package com.joyeria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joyeria.dto.JoyaDTO;
import com.joyeria.model.Joya;
import com.joyeria.repository.IJoyeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyeriaServiceImpl implements IJoyeriaService {

    @Autowired
    IJoyeriaRepository joyeriaRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public JoyaDTO createJoya(JoyaDTO joyaDTO) {
        joyaDTO.setVentaONo(true);
        Joya joya = joyeriaRepository.save(objectMapper.convertValue(joyaDTO, Joya.class));
        return objectMapper.convertValue(joya, JoyaDTO.class);
    }

    @Override
    public List<JoyaDTO> findAllJoyas() {
        List<Joya> joyas = joyeriaRepository.findAll();
        joyas = joyas.stream().filter(j -> j.getVentaONo()).toList();
        return joyas.stream().map(joya -> objectMapper.convertValue(joya, JoyaDTO.class)).toList();
    }

    @Override
    public JoyaDTO findJoyaById(int id) {
        Optional<Joya> joya = joyeriaRepository.findById(id);
        if (joya.isEmpty() || !joya.get().getVentaONo()) {
            throw new RuntimeException("Joya not found");
        }

        return objectMapper.convertValue(joya.get(), JoyaDTO.class);
    }

    @Override
    public JoyaDTO updateJoya(int id, JoyaDTO joyaDTO) {
        Optional<Joya> joya = joyeriaRepository.findById(id);
        if (joya.isEmpty()) {
            throw new RuntimeException("Joya not found");
        }

        Joya updatedJoya = joya.get();

        updatedJoya.setName(joyaDTO.getName());
        updatedJoya.setMaterial(joyaDTO.getMaterial());
        updatedJoya.setPeso(joyaDTO.getPeso());
        updatedJoya.setParticularidad(joyaDTO.getParticularidad());
        updatedJoya.setPoseePiedra(joyaDTO.getPoseePiedra());
        updatedJoya.setVentaONo(joyaDTO.getVentaONo());

        Joya newJoya = joyeriaRepository.save(updatedJoya);
        return objectMapper.convertValue(newJoya, JoyaDTO.class);
    }

    @Override
    public String deleteJoya(int id) {
        Optional<Joya> joya = joyeriaRepository.findById(id);
        if (joya.isEmpty()) {
            throw new RuntimeException("Joya not found");
        }

        JoyaDTO deletedJoya = objectMapper.convertValue(joya.get(), JoyaDTO.class);
        deletedJoya.setVentaONo(false);
        updateJoya(id, deletedJoya);

        return "Joya deleted";
    }
}
