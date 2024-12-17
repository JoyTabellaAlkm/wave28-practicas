package com.ejercicios.deportistas.services;

import com.ejercicios.deportistas.dto.DeporteDTO;
import com.ejercicios.deportistas.dto.DeportePersonaDTO;
import com.ejercicios.deportistas.dto.responses.DeportesYPersonasResponse;
import com.ejercicios.deportistas.models.DeportePersonaModel;
import com.ejercicios.deportistas.models.DeportesModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteImpl implements IDeporte{

    @Override
    public List<DeporteDTO> listaDeportes(){
        return DeportesModel.getListaDeportes();
    }

    @Override
    public DeporteDTO encontrarDeporte(String nombre){
        List<DeporteDTO> listaDeportes = listaDeportes();
        DeporteDTO deporte = listaDeportes
                .stream()
                .filter(deporteDTO -> deporteDTO.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
        return deporte;
    }

    @Override
    public List<DeportesYPersonasResponse> encontrarDeportesPersonas() {
        List<DeportesYPersonasResponse> response = new ArrayList<>();
        List<DeportePersonaDTO> listadoGeneral = DeportePersonaModel.getDeportePersona();
        for(DeportePersonaDTO list : listadoGeneral){
            response.add(new DeportesYPersonasResponse(
                    list.getPersona().getNombre(),
                    list.getPersona().getApellido(),
                    list.getDeporte().getNombre()
            ));
        }
        return response;
    }
}
