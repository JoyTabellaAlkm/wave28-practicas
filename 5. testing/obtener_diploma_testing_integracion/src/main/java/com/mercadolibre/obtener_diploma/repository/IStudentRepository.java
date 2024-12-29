package com.mercadolibre.obtener_diploma.repository;

import java.util.Set;

import com.mercadolibre.obtener_diploma.model.StudentDTO;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
