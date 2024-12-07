package com.meli.deportista.models;

import com.meli.deportista.dto.DeporteDto;
import com.meli.deportista.dto.DeportePersonaDto;
import com.meli.deportista.dto.PersonaDto;

import java.util.ArrayList;
import java.util.List;

public class DeportePersonaModel {
    private static List<DeportePersonaDto> deportePersona;

    static {
        deportePersona = new ArrayList<DeportePersonaDto>();
        List<DeporteDto> listaDeportes = DeportesModel.getListaDeportes();
        List<PersonaDto> listaPersonas = PersonasModel.getListaPersonas();

        for (DeporteDto deporte : listaDeportes) {
            for (PersonaDto persona : listaPersonas) {
                deportePersona.add(new DeportePersonaDto(deporte, persona)); // Crear la relación
            }
        }
    }

    public static List<DeportePersonaDto> getDeportePersona() {
        return deportePersona;
    }
}