package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.Set;

public interface IStudentService {
    StudentDTO create(StudentDTO stu);
    StudentDTO read(Long id);
    void update(StudentDTO stu);
    boolean delete(Long id);
    Set<StudentDTO> getAll();
}
