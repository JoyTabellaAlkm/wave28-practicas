package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.Student;

import java.util.List;

public interface IStudentService {
    Student create(Student stu);
    Student read(Long id);
    Student update(Student stu);
    void delete(Long id);
    List<Student> getAll();
}
