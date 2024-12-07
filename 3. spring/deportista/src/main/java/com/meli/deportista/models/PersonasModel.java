package com.meli.deportista.models;


import com.meli.deportista.dto.DeporteDto;
import com.meli.deportista.dto.PersonaDto;

import java.util.ArrayList;
import java.util.List;

public class PersonasModel {
    private static List<PersonaDto> listaPersonas;

    static {
        listaPersonas = new ArrayList<PersonaDto>();

        listaPersonas.add(new PersonaDto("gabriel","Viloria","26"));
        listaPersonas.add(new PersonaDto("Klaus","Cerrano","25"));
        listaPersonas.add(new PersonaDto("Maria","Silva","21"));
    }

    public static List<PersonaDto> getListaPersonas() {
        return listaPersonas;
    }
}
