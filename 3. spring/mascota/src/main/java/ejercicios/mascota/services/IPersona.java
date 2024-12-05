package ejercicios.mascota.services;

import ejercicios.mascota.dto.responses.RespuestaDto;
import ejercicios.mascota.dto.requests.PersonaDto;

public interface IPersona {
    RespuestaDto agregarPersonaDTO(PersonaDto persona);
}
