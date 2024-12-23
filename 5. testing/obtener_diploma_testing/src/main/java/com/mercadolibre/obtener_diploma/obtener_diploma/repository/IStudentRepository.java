package com.mercadolibre.obtener_diploma.obtener_diploma.repository;

import com.mercadolibre.obtener_diploma.obtener_diploma.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
