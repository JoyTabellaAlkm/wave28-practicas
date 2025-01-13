package org.ejercicios.lasperlas.service;

import org.ejercicios.lasperlas.model.Joya;
import org.ejercicios.lasperlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    @Autowired
    IJoyaRepository joyarepo;


    @Override
    public List<Joya> getJoyas() {
        return joyarepo.findByVentaONoTrue();
    }

    @Override
    public Joya findJoya(Long id) {
        int idInt = id.intValue();
        return joyarepo.findById(idInt).orElse(null);
    }

    @Override
    public Long saveJoya(Joya joya) {
        joya.setVentaONo(true);
        Joya savedJoya = joyarepo.save(joya);
        return savedJoya.getId();
    }

    @Override
    public void deleteJoya(Long id) {
        Joya joyaEncontrada = this.findJoya(id);
        joyaEncontrada.setVentaONo(false);
        joyarepo.save(joyaEncontrada);
    }

    @Override
    public Joya editJoya(Long id_modificar, Joya joya_modif) {
        Joya joyaActualizar = this.findJoya(id_modificar);
        joyaActualizar.setNombre(joya_modif.getNombre());
        joyaActualizar.setMaterial(joya_modif.getMaterial());
        joyaActualizar.setPesoGramos(joya_modif.getPesoGramos());
        joyaActualizar.setParticularidad(joya_modif.getParticularidad());
        joyaActualizar.setPoseePiedra(joya_modif.isPoseePiedra());
        joyaActualizar.setVentaONo(joya_modif.isVentaONo());
        return  joyarepo.save(joyaActualizar);
    }
}
