package com.mercadolibre.deportistas.service.impl;

import com.mercadolibre.deportistas.dto.request.DeporteDTO;
import com.mercadolibre.deportistas.dto.response.DeporteNombreDTO;
import com.mercadolibre.deportistas.dto.response.DeportistaDTO;
import com.mercadolibre.deportistas.dto.request.PersonaDTO;
import com.mercadolibre.deportistas.service.IPersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    List<PersonaDTO> listaPersona = new ArrayList<>();

    private void setListaPersona(){
        DeporteDTO deporteDTO1 = new DeporteDTO("Padel", "Medio");
        DeporteDTO deporteDTO2 = new DeporteDTO("Tenis", "Dificil");
        DeporteDTO deporteDTO3 = new DeporteDTO("Tenis de mesa", "Facil");
        PersonaDTO personaDTO1 = new PersonaDTO("Juan","Abarca", 22, deporteDTO1);
        PersonaDTO personaDTO2 = new PersonaDTO("Julian","Ramirez", 25, deporteDTO3);
        PersonaDTO personaDTO3 = new PersonaDTO("Roberto","Alfonsin", 19, deporteDTO2);
        PersonaDTO personaDTO4 = new PersonaDTO("Federico","Capo", 22, deporteDTO1);
        listaPersona.add(personaDTO1);
        listaPersona.add(personaDTO2);
        listaPersona.add(personaDTO3);
        listaPersona.add(personaDTO4);
    }
    @Override
    public List<DeportistaDTO> devolverDeportistas() {
        setListaPersona();
        List<DeportistaDTO> deportistaDTOLista = new ArrayList<>();
        listaPersona.forEach(persona->{
            DeportistaDTO deportistaDTO = new DeportistaDTO();
            deportistaDTO.setNombreCompleto(persona.getNombre()+" "+persona.getApellido());
            DeporteNombreDTO deporteNombreDTO = new DeporteNombreDTO();
            deporteNombreDTO.setNombre(persona.getDeporteDTO().getNombre());
            deportistaDTO.setNombreDeporte(deporteNombreDTO);
            deportistaDTOLista.add(deportistaDTO);
        });

        return deportistaDTOLista;
    }
}
