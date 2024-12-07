package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dto.PacienteDTO;

import java.util.List;

public interface IPaciente {

    PacienteDTO agregarPaciente (PacienteDTO pacienteDTO);

    List<PacienteDTO> obtenerPacienteConSintoma();
}
