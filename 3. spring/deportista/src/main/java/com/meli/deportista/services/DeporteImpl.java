package com.meli.deportista.services;

import com.meli.deportista.dto.DeporteDto;
import com.meli.deportista.dto.DeportePersonaDto;
import com.meli.deportista.dto.responses.DeportesYPersonasResponse;
import com.meli.deportista.models.DeportePersonaModel;
import com.meli.deportista.models.DeportesModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DeporteImpl implements IDeporte{

    @Override
    public List<DeporteDto> listaDeportes(){
        return DeportesModel.getListaDeportes();
    }

    @Override
    public DeporteDto encontrarDeporte(String nombre){
        List<DeporteDto> listaDeportes = listaDeportes();
        DeporteDto deporte = listaDeportes
                .stream()
                .filter(deporteDTO -> deporteDTO.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
        return deporte;
    }

    @Override
    public List<DeportesYPersonasResponse> encontrarDeportesPersonas() {
        List<DeportesYPersonasResponse> response = new ArrayList<>();
        List<DeportePersonaDto> listadoGeneral = DeportePersonaModel.getDeportePersona();
        for(DeportePersonaDto list : listadoGeneral){
            response.add(new DeportesYPersonasResponse(
                    list.getPersona().getNombre(),
                    list.getPersona().getApellido(),
                    list.getDeporte().getNombre()
            ));
        }
        return response;
    }
}
