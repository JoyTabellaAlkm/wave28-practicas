package com.example.deportista.dto.response;

import com.example.deportista.dto.request.PersonaDTO;
import com.example.deportista.dto.request.PersonaDeportistaDTO;
import lombok.Data;

import java.util.List;

@Data
public class PersonasDeportistasResponseDto {
    private List<PersonaDeportistaDTO> personasDeportistas;
}
