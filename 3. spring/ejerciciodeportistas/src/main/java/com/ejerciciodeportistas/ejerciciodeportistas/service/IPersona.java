package com.ejerciciodeportistas.ejerciciodeportistas.service;

import com.ejerciciodeportistas.ejerciciodeportistas.dto.RespuestaDTO;
import com.ejerciciodeportistas.ejerciciodeportistas.dto.response.PersonaDTO;
import lombok.NoArgsConstructor;


public interface IPersona {

    RespuestaDTO agregarPersona(PersonaDTO personaDTO);
}
