package com.meli.ejercicio_diploma.repository;

import com.meli.ejercicio_diploma.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
