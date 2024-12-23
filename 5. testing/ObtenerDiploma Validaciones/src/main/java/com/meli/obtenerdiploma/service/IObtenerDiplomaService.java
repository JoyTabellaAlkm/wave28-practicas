package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);

    StudentDTO getName(String studentName);

    StudentDTO addStudent(StudentDTO rq);

    StudentDTO getNameRqParam(String studentName);
}
