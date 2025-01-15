package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.JoyaDto;
import com.bootcamp.LasPerlas.dto.MensajeDto;
import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository joyaRepo;
    ModelMapper mapper= new ModelMapper();

    @Override
    public MensajeDto saveJoya(JoyaDto joyaDto) {

        Joya joya = new Joya();
        joya= mapper.map(joyaDto, Joya.class);
       joyaRepo.save(joya);

       return new MensajeDto("La joya se creo correctamente : # " + joya.getId());
    }

    @Override
    public List<JoyaDto> getJoyas() {

        List<JoyaDto> listJoyaDto = new ArrayList<>();
        for (Joya joya : joyaRepo.findAll()) {
            listJoyaDto.add(mapper.map(joya, JoyaDto.class));
        }
        return listJoyaDto;

    }

    @Override
    public JoyaDto findJoya(Long id) {
        return mapper.map(joyaRepo.findById(id).orElse(null), JoyaDto.class);
    }

    @Override
    public MensajeDto deleteJoya(Long id) {
        Joya joyaOriginal = joyaRepo.findById(id).orElse(null);
        joyaOriginal.setVentaONo(false);
        joyaRepo.delete(joyaOriginal);

        return new MensajeDto("Joya dada de baja para la venta correctamente");
    }

    @Override
    public MensajeDto editJoya(Long id_modificar, JoyaDto joya_modif) {
        this.findJoya(id_modificar);
        Joya joya = new Joya();
        joya= mapper.map(joya_modif, Joya.class);
        joya.setId(id_modificar);
        joyaRepo.save(joya);

        return new MensajeDto("Modificaciones guardadas correctamente");

    }
}
