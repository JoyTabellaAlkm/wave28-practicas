package com.ejercicios.deportistas.models;

import com.ejercicios.deportistas.dto.DeporteDTO;

import java.util.ArrayList;
import java.util.List;

public class DeportesModel {
    private static List<DeporteDTO> listaDeportes;

    static {
        listaDeportes = new ArrayList<>();
        listaDeportes.add(new DeporteDTO("Tennis", "principiante"));
        listaDeportes.add(new DeporteDTO("Futbol", "intermedio"));
        listaDeportes.add(new DeporteDTO("Basketball", "avanzado"));
    }
    public static List<DeporteDTO> getListaDeportes() {
        return listaDeportes;
    }

}
