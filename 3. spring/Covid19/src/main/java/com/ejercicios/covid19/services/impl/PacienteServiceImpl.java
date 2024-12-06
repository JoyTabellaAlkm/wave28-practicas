package com.ejercicios.covid19.services.impl;

import com.ejercicios.covid19.DTO.PacienteDTO;
import com.ejercicios.covid19.DTO.response.PacienteRiesgoDTO;
import com.ejercicios.covid19.Repository.PacienteRepository;
import com.ejercicios.covid19.Repository.PacienteRepositoryImpl;
import com.ejercicios.covid19.models.Sintoma;
import com.ejercicios.covid19.services.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService {

    public PacienteRepository pacienteRepository = new PacienteRepositoryImpl();

    @Override
    public List<Sintoma> devolverSintomas() {

        return pacienteRepository.findAllSymtom();
    }

    @Override
    public Integer consultarSintoma(String nombre) {
        Sintoma respuesta = pacienteRepository.findSintomaByName(nombre);
        return respuesta.getNivelDeGravedad();
    }

    @Override
    public List<PacienteRiesgoDTO> devolverPacientesRiesgo() {
        List<PacienteDTO> rta = pacienteRepository.findPacientesByRiskAgeAge();

        List<PacienteRiesgoDTO> algo = new ArrayList<>();
        for (PacienteDTO p : rta){
            algo.add(new PacienteRiesgoDTO(p.getPersona().getNombre(), p.getPersona().getApellido()));
        }
        return algo;

/*        return rta.stream()
                .map(pacienteDTO -> new PacienteRiesgoDTO(pacienteDTO.getPersona().getNombre(),
                        pacienteDTO.getPersona().getApellido())
                ).toList();*/



    }


}
