package com.mercadolibre.student.service;

import com.mercadolibre.student.entity.Student;

import java.util.List;

public interface IStudentService {
    Student save(Student student);

    List<Student> findAll();

    Student findById(Long id);

    Student update(Long id, Student student);

    void delete(Long id);
}
