package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.List;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);

    StudentDTO addStudent (StudentDTO student);

    List<StudentDTO> getAll();

    StudentDTO findByName (String student);
}
