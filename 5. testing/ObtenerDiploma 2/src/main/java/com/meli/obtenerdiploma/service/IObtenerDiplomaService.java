package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
    Double calculateAverage(List<SubjectDTO> scores);
    String getGreetingMessage(String studentName, Double average);
}
