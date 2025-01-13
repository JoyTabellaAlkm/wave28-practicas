package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.MensajeDto;
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
    public MensajeDto saveJoya(Joya joya) {
       joyaRepo.save(joya);

       return new MensajeDto("La joya se creo correctamente : # " + joya.getNro_id());
    }

    @Override
    public List<Joya> getJoyas() {

        return joyaRepo.findAll();

    }

    @Override
    public Joya findJoya(Long id) {
        //el orElse nos permite devolver null en caso que no encuentre
        return joyaRepo.findById(id).orElse(null);
    }

    @Override
    public MensajeDto deleteJoya(Long id) {

        //haremos borrado lógico, por lo cual no eliminamos el registro de la bd
        //sino que solo cambiamos su estado de verdadero (a la venta) a falso (no a la venta)

        Joya joyaOriginal = this.findJoya(id);
        joyaOriginal.setVentaONo(false);
        this.saveJoya(joyaOriginal);

        return new MensajeDto("Joya dada de baja para la venta correctamente");
    }

    @Override
    public MensajeDto editJoya(Long id_modificar, Joya joya_modif) {

        Joya joyaOriginal = this.findJoya(id_modificar);

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.isPosee_piedra());
        joyaOriginal.setVentaONo(joya_modif.isVentaONo());

        this.saveJoya(joyaOriginal);
        return new MensajeDto("Modificaciones guardadas correctamente");

    }
}
