package com.meli.ejercicio_diploma.service;

import com.meli.ejercicio_diploma.model.StudentDTO;

import java.util.Set;

public interface IStudentService {
    boolean create(StudentDTO stu);
    StudentDTO read(Long id);
    boolean update(StudentDTO stu);
    boolean delete(Long id);
    Set<StudentDTO> getAll();
}
