package com.meli.ejercicio_diploma.service;

import com.meli.ejercicio_diploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
}
