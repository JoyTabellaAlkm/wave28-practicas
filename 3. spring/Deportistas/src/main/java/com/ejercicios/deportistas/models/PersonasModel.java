package com.ejercicios.deportistas.models;

import com.ejercicios.deportistas.dto.PersonaDTO;

import java.util.ArrayList;
import java.util.List;

public class PersonasModel {
    private static List<PersonaDTO> listaPersonas;

    static {
        listaPersonas = new ArrayList<PersonaDTO>();

        listaPersonas.add(new PersonaDTO("gabriel","Viloria","26"));
        listaPersonas.add(new PersonaDTO("Klaus","Cerrano","25"));
        listaPersonas.add(new PersonaDTO("Maria","Silva","21"));
    }

    public static List<PersonaDTO> getListaPersonas() {
        return listaPersonas;
    }
}
