package com.meli.deportista.models;

import com.meli.deportista.dto.DeporteDto;

import java.util.ArrayList;
import java.util.List;

public class DeportesModel {
    private static List<DeporteDto> listaDeportes;

    static {
        listaDeportes = new ArrayList<>();
        listaDeportes.add(new DeporteDto("Tennis", "principiante"));
        listaDeportes.add(new DeporteDto("Futbol", "intermedio"));
        listaDeportes.add(new DeporteDto("Basketball", "avanzado"));
    }
    public static List<DeporteDto> getListaDeportes() {
        return listaDeportes;
    }

}
