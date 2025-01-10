package com.example.AlumnoDTORP.service;

import com.example.AlumnoDTORP.dto.AlumnoDTO;
import com.example.AlumnoDTORP.dto.RespuestaDTO;
import com.example.AlumnoDTORP.model.Alumno;
import com.example.AlumnoDTORP.repository.IAlumnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
    @Autowired
    private IAlumnoRepository alumnoRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public RespuestaDTO agregarAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno();
        modelMapper.map(alumnoDTO,alumno);
        alumnoRepository.save(alumno);
        return new RespuestaDTO("Alumno agregado correctamente");
    }
    //@Transactional(readOnly = true)
    public List<AlumnoDTO> listarAlumnos() {
        return alumnoRepository.findAll().stream()
                .map(alumno -> modelMapper.map(alumno, AlumnoDTO.class))
                .collect(Collectors.toList());
    }

}
