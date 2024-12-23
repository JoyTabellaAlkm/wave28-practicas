package com.mercadolibre.obtener_diploma.obtener_diploma.service;

import com.mercadolibre.obtener_diploma.obtener_diploma.model.StudentDTO;

import java.util.Set;

public interface IStudentService {
    void create(StudentDTO stu);

    StudentDTO read(Long id);

    void update(StudentDTO stu);

    void delete(Long id);

    Set<StudentDTO> getAll();
}
