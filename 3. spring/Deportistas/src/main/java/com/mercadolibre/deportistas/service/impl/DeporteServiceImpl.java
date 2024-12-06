package com.mercadolibre.deportistas.service.impl;

import com.mercadolibre.deportistas.dto.request.DeporteDTO;
import com.mercadolibre.deportistas.service.IDeporteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteServiceImpl implements IDeporteService {
    List<DeporteDTO> listaDeportes = new ArrayList<>();

    private void setListaDeportes() {
        //Esto no iria, esta harcodeado para que ande
        DeporteDTO deporteDTO1 = new DeporteDTO("Padel", "Medio");
        DeporteDTO deporteDTO2 = new DeporteDTO("Tenis", "Dificil");
        DeporteDTO deporteDTO3 = new DeporteDTO("Tenis de mesa", "Facil");
        listaDeportes.add(deporteDTO1);
        listaDeportes.add(deporteDTO2);
        listaDeportes.add(deporteDTO3);
    }

    @Override
    public List<DeporteDTO> buscarDeportes() {
        //Set de hardcodeo
        setListaDeportes();

        return listaDeportes;
    }

    @Override
    public String buscarDeportePorNombre(String nombre) {
        //Set de hardcodeo
        setListaDeportes();

        DeporteDTO deporteBuscado = listaDeportes.stream().filter(deporte -> deporte
                        .getNombre()
                        .equalsIgnoreCase(nombre))
                .findFirst()
                .get();

        return deporteBuscado.getNivel();
    }
}
