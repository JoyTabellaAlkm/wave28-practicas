package com.mercadolibre.testing.obtener_diploma.service;

import com.mercadolibre.testing.obtener_diploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);

}
