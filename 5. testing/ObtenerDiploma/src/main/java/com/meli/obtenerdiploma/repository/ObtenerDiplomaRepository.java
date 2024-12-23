package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ObtenerDiplomaRepository implements iObtenerDiplomaRepository {

    List<StudentDTO> students = new ArrayList<>();

    @Override
    public StudentDTO addStudent(StudentDTO student) {
        students.add(student);
        return student;
    }

    @Override
    public List<StudentDTO> getAll() {
        return students;
    }

    @Override
    public StudentDTO findByName(String student) {
        return students.stream().filter(value -> value.getStudentName().equals(student)).findAny().orElse(null);
    }

    @Override
    public boolean deleteByName(String name) {
        StudentDTO s = students.stream().filter(value -> value.getStudentName().equals(name)).findAny().orElse(null);
        return students.remove(s);
    }
}
