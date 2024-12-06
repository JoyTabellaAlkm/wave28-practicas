package com.ejerciciodeportistas.ejerciciodeportistas.service;

import com.ejerciciodeportistas.ejerciciodeportistas.dto.RespuestaDTO;
import com.ejerciciodeportistas.ejerciciodeportistas.dto.response.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaImpl implements IPersona{

    List<PersonaDTO> personasDtoList = new ArrayList<>();

    @Override
    public RespuestaDTO agregarPersona(PersonaDTO personaDTO){
        personasDtoList.add(personaDTO);
        RespuestaDTO res = new RespuestaDTO("Persona agregada correctamente");
        return res;
    }

}
