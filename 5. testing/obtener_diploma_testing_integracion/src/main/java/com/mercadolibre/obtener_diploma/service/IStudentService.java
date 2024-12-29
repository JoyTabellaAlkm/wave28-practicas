package com.mercadolibre.obtener_diploma.service;

import java.util.Set;

import com.mercadolibre.obtener_diploma.model.StudentDTO;

public interface IStudentService {
    void create(StudentDTO stu);

    StudentDTO read(Long id);

    void update(StudentDTO stu);

    void delete(Long id);

    Set<StudentDTO> getAll();
}
