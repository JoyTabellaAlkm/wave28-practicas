package ejercicios.mascota.services;

import ejercicios.mascota.dto.responses.RespuestaDto;
import ejercicios.mascota.dto.requests.PersonaDto;

import java.util.ArrayList;
import java.util.List;

public class PersonaImpl implements IPersona{
    List<PersonaDto> personaDtolist = new ArrayList<PersonaDto>();


    @Override
    public RespuestaDto agregarPersonaDTO(PersonaDto persona) {
        RespuestaDto respuesta = new RespuestaDto("persona agregada");
        return respuesta;
    }
}
