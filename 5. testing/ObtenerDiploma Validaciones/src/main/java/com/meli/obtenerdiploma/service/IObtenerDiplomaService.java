package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.List;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);

    StudentDTO getName(String studentName);

    StudentDTO addStudent(StudentDTO rq);

    StudentDTO getNameRqParam(String studentName);
    List<StudentDTO> getAll();
}
