package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

import javax.validation.Valid;

public interface IStudentDAO {
    void save(@Valid StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}