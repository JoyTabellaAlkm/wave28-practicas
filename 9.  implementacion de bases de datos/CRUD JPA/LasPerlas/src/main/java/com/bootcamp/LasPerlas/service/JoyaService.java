package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.JewelryListResponse;
import com.bootcamp.LasPerlas.dto.JewelResponse;
import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository joyaRepo;

    @Override
    public JewelResponse saveJoya(Joya joya) {
       Joya created = joyaRepo.save(joya);

       return new JewelResponse("Registro creado con el Id "+ created.getNro_id(), HttpStatus.CREATED.value());
    }

    @Override
    public JewelryListResponse getJoyas() {
        return new JewelryListResponse(HttpStatus.OK.value(),
                joyaRepo.findAll().stream().filter(Joya::isVentaONo).collect(Collectors.toList()));
    }

    @Override
    public Joya findJoya(Long id) {
        //el orElse nos permite devolver null en caso que no encuentre
        return joyaRepo.findById(id).orElse(null);
    }

    @Override
    public JewelResponse deleteJoya(Long id) {

        //haremos borrado lógico, por lo cual no eliminamos el registro de la bd
        //sino que solo cambiamos su estado de verdadero (a la venta) a falso (no a la venta)

        Joya joyaOriginal = this.findJoya(id);

        if (joyaOriginal == null) return new JewelResponse("No existe el id de la joya enviada", HttpStatus.NOT_FOUND.value());
        if (!joyaOriginal.isVentaONo()) return new JewelResponse("La joya ya se había dado de baja anteriormente", HttpStatus.BAD_REQUEST.value());
        joyaOriginal.setVentaONo(false);
        this.saveJoya(joyaOriginal);

        return new JewelResponse("La joya ha sido dada de baja correctamente", HttpStatus.OK.value());
    }

    @Override
    public JewelResponse editJoya(Long id_modificar, Joya joya_modif) {

        Joya joyaOriginal = this.findJoya(id_modificar);
        if (joyaOriginal == null) return new JewelResponse("El id enviado no existe.", HttpStatus.NOT_MODIFIED.value());

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.isPosee_piedra());
        joyaOriginal.setVentaONo(joya_modif.isVentaONo());

        this.saveJoya(joyaOriginal);
        return new JewelResponse("Modificaciones guardadas correctamente", HttpStatus.OK.value());

    }
}
