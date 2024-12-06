package com.ejercicios.covid19.Repository;

import com.ejercicios.covid19.DTO.PacienteDTO;
import com.ejercicios.covid19.models.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PacienteRepository {
    public List<Sintoma> findAllSymtom();
    public Sintoma findSintomaByName(String name);
    public List<PacienteDTO> findPacientesByRiskAgeAge();
}
