package com.mercadolibre.obtener_diploma.obtener_diploma.repository;

import com.mercadolibre.obtener_diploma.obtener_diploma.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);

    boolean delete(Long id);

    boolean exists(StudentDTO stu);

    StudentDTO findById(Long id);
}
