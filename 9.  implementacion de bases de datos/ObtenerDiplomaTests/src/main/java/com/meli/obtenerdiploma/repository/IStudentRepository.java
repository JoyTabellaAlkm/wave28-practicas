package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
