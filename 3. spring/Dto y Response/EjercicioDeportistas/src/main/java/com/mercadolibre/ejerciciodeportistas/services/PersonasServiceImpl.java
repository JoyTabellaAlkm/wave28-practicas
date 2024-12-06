package com.mercadolibre.ejerciciodeportistas.services;

import com.mercadolibre.ejerciciodeportistas.response.PersonaDTOResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonasServiceImpl implements IPersonas{

    List<PersonaDTOResponse> personas = new ArrayList<>(List.of(
            new PersonaDTOResponse("Daniel", "Franco", "ciclismo"),
            new PersonaDTOResponse("Valentina", "Franco", "Patinaje")
    ));

    @Override
    public List<PersonaDTOResponse> devolverPersonas() {
        return personas;
    }
}
