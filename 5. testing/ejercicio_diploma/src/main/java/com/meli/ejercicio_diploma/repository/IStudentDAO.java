package com.meli.ejercicio_diploma.repository;

import com.meli.ejercicio_diploma.model.StudentDTO;

public interface IStudentDAO {
    boolean save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}