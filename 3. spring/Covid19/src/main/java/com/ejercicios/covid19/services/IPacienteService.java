package com.ejercicios.covid19.services;

import com.ejercicios.covid19.DTO.response.PacienteRiesgoDTO;
import com.ejercicios.covid19.models.Sintoma;

import java.util.List;

public interface IPacienteService {
    List<Sintoma> devolverSintomas();

    Integer consultarSintoma(String nombre);

    List<PacienteRiesgoDTO> devolverPacientesRiesgo();

}
