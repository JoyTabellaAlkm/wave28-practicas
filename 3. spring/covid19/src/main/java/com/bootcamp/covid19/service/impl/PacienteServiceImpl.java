package com.bootcamp.covid19.service.impl;

import com.bootcamp.covid19.dto.PacienteDTO;
import com.bootcamp.covid19.dto.SintomaDTO;
import com.bootcamp.covid19.service.IPaciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImpl implements IPaciente {
    List<PacienteDTO> pacienteDTOList = new ArrayList<>();
    @Override
    public PacienteDTO agregarPaciente(PacienteDTO pacienteDTO) {
        List<SintomaDTO> sintomasList = pacienteDTO.getSintomasList();
        PacienteDTO paciente1 = new PacienteDTO();
        paciente1.setNombre(pacienteDTO.getNombre());
        paciente1.setApellido(pacienteDTO.getApellido());
        paciente1.setEdad(pacienteDTO.getEdad());
        paciente1.setSintomasList(sintomasList);

        pacienteDTOList.add(paciente1);
        return paciente1;
    }

    @Override
    public List<PacienteDTO> obtenerPacienteConSintoma() {

        List<PacienteDTO> pacientesMayores = pacienteDTOList.stream()
                .filter(p-> p.getEdad() > 60 && p.getSintomasList() != null && !p.getSintomasList().isEmpty())
                .toList();
        return pacientesMayores;
    }
}
