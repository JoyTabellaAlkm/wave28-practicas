package com.example.covid.DTO;

import java.util.List;

public class PersonaXSintomaDTO {
    PersonaDTO personaDTO;
    List<SintomaDTO> sintomaDTO;

    public PersonaXSintomaDTO(PersonaDTO personaDTO, List<SintomaDTO> sintomaDTO) {
        this.personaDTO = personaDTO;
        this.sintomaDTO = sintomaDTO;
    }

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

    public List<SintomaDTO> getSintomaDTO() {
        return sintomaDTO;
    }

    public void setSintomaDTO(List<SintomaDTO> sintomaDTO) {
        this.sintomaDTO = sintomaDTO;
    }
}
