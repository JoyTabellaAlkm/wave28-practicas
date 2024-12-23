package com.mercadolibre.obtener_diploma.obtener_diploma.service;

import com.mercadolibre.obtener_diploma.obtener_diploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
}
