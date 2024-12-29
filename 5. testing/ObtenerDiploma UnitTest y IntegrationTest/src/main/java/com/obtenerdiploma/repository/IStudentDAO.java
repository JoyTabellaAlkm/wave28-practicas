package com.obtenerdiploma.repository;

import com.obtenerdiploma.entity.Student;

import java.util.Optional;
import java.util.Set;

public interface IStudentDAO {

    Set<Student> findAll();

    boolean save(Student stu);

    boolean delete(Long id);

    Optional<Student> findById(Long id);

    boolean exists(Student stu);
}
