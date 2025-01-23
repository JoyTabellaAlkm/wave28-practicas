package com.example.segurosdeautos.service;

import com.example.segurosdeautos.dto.request.SiniestroRequestDto;
import com.example.segurosdeautos.dto.response.SiniestroResponseDto;

import java.util.List;

public interface ISiniestroService {
    SiniestroResponseDto crearSiniestro(SiniestroRequestDto siniestro);
    List<SiniestroResponseDto> obtenerTodosLosSiniestros();
    SiniestroResponseDto obtenerSiniestroPorId(Long id);
}
