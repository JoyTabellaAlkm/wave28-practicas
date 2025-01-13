package com.mercadolibre.joyerialasperlas.service;

import com.mercadolibre.joyerialasperlas.entity.Joya;
import com.mercadolibre.joyerialasperlas.repository.IJoyaRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    private final IJoyaRespository joyaRespository;

    public JoyaService(IJoyaRespository joyaRespository) {
        this.joyaRespository = joyaRespository;
    }

    @Override
    public Long createJoya(Joya joya) {
        joyaRespository.save(joya);
        return joya.getNro_identificatorio();
    }

    @Override
    public List<Joya> getAllJoyas() {
        List<Joya> joyas = joyaRespository.findAll();
        joyas.removeIf(joya -> !joya.isVentaONo());
        return joyas;
    }

    @Override
    public Joya getJoyaById(Long id) {
        return joyaRespository.findById(id).orElse(null);
    }

    @Override
    public void deleteJoya(Long id) {
        //joyaRespository.deleteById(id);
        Joya joya = joyaRespository.findById(id).orElse(null);
        if (joya != null) {
            joya.setVentaONo(false);
            joyaRespository.save(joya);
        }
    }

    @Override
    public Joya updateJoya(Long id, Joya joya) {
        Joya joyaToUpdate = joyaRespository.findById(id).orElse(null);
        if (joyaToUpdate != null) {
            joyaToUpdate.setNombre(joya.getNombre());
            joyaToUpdate.setMaterial(joya.getMaterial());
            joyaToUpdate.setParticularidad(joya.getParticularidad());
            joyaToUpdate.setPosee_piedra(joya.isPosee_piedra());
            joyaToUpdate.setVentaONo(joya.isVentaONo());
            joyaRespository.save(joyaToUpdate);
        }else {
            throw new RuntimeException("Joya not found");
        }
        return joyaToUpdate;
    }
}
