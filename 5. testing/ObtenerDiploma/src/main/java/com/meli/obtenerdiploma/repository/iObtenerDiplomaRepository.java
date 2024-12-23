package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.List;

public interface iObtenerDiplomaRepository {

    StudentDTO addStudent (StudentDTO student);

    List<StudentDTO> getAll();

    StudentDTO findByName (String student);

    boolean deleteByName (String name);
}
