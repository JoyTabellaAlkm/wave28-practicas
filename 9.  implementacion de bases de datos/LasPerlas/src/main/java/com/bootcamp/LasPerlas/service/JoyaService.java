package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository joyaRepo;

    @Override
    public String saveJoya(Joya joya) {
       joyaRepo.save(joya);

       return "Joya guardada correctamente";
    }

    @Override
    public List<Joya> getJoyas() {

        return joyaRepo.findAllByVentaONoIsTrue();

    }

    @Override
    public Joya findJoya(Long id) {
        return joyaRepo.findById(id).orElse(null);
    }

    @Override
    public String deleteJoya(Long id) {

        Joya joyaOriginal = this.findJoya(id);
        if(!joyaOriginal.isVentaONo()){
            return "Esa joya ya esta dada de baja para la venta";
        }
        joyaOriginal.setVentaONo(false);
        this.saveJoya(joyaOriginal);

        return "Joya dada de baja para la venta correctamente";
    }

    @Override
    public String editJoya(Long id_modificar, Joya joya_modif) {

        Joya joyaOriginal = this.findJoya(id_modificar);

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.isPosee_piedra());
        joyaOriginal.setVentaONo(joya_modif.isVentaONo());

        this.saveJoya(joyaOriginal);
        return "Modificaciones guardadas correctamente";

    }

    @Override
    public List<Joya> findAllByMaterial(String material) {
        return joyaRepo.findAllByMaterialAndVentaONoIsTrue(material);
    }


}
