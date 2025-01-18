package org.example.lasperlasjoyeria.service;

import org.example.lasperlasjoyeria.model.Joya;
import org.example.lasperlasjoyeria.repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService {

    @Autowired
    JoyaRepository joyaRepository;

    public Long addJoya(Joya newJoya) {
        Joya savedJoya = this.joyaRepository.save(newJoya);
        return savedJoya.getId();
    }

    public List<Joya> getAllJoyas() {
        return this.joyaRepository.findAll();
    }

    public Joya deleteJoyaById(Long id) {
        Joya joya = getJoyaById(id);
        if(joya != null) {
            joya.setVentaONo(false);
        }
        return joya;
    }

    public Joya updateJoya(Long id, Joya joya) {
        Joya joyaToUpdate = getJoyaById(id);

        joyaToUpdate.setMaterial(joya.getMaterial());
        joyaToUpdate.setNombre(joya.getNombre());
        joyaToUpdate.setVentaONo(joya.isVentaONo());
        joyaToUpdate.setParticularidad(joya.getParticularidad());
        joyaToUpdate.setPeso(joya.getPeso());
        joyaToUpdate.setPosee_piedra(joya.isPosee_piedra());

        return this.joyaRepository.save(joyaToUpdate);
    }

    private Joya getJoyaById(Long id) {
        return this.joyaRepository.findById(id).orElse(null);
    }

}
