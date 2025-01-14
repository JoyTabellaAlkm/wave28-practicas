package com.example.api_joyas.service;

import com.example.api_joyas.exception.NotFoundException;
import com.example.api_joyas.model.Joya;
import com.example.api_joyas.repository.JoyaRepository;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.midi.MidiMessage;
import java.util.List;

@Service
public class JoyaServiceImpl implements JoyaService{

    private final JoyaRepository joyaRepository;
    public JoyaServiceImpl(JoyaRepository joyaRepository){
        this.joyaRepository=joyaRepository;
    }

    @Override
    public Long createJoya(Joya joya) {
        joya.setVentaONo(true);
        joyaRepository.save(joya);
        return joya.getId();
    }

    @Override
    public Joya findJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        return joya;
    }

    @Override
    public List<Joya> getJoyas() {
        return joyaRepository.findAll().stream()
                .filter(m->m.isVentaONo())
                .toList();
    }

    @Override
    public Long deleteJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElseThrow(()-> new NotFoundException(id,"joya"));
        joya.setVentaONo(false);
        joyaRepository.save(joya);
        return id;
    }

    @Transactional
    public Long updateJoya(Long id, Joya updatedJoya) {
        Joya existingJoya = joyaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id,"joya"));

        // Actualizar los campos de la joya existente
        if (updatedJoya.getNombre() != null) existingJoya.setNombre(updatedJoya.getNombre());
        if (updatedJoya.getMaterial() != null) existingJoya.setMaterial(updatedJoya.getMaterial());
        if (updatedJoya.getPeso() != null) existingJoya.setPeso(updatedJoya.getPeso());
        if (updatedJoya.getParticularidad() != null) existingJoya.setParticularidad(updatedJoya.getParticularidad());
        existingJoya.setPosee_piedra(updatedJoya.isPosee_piedra());

        joyaRepository.save(existingJoya);
        return id;
    }

}
