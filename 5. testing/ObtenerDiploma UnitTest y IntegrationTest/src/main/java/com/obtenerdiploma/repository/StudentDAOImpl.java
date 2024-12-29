package com.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.obtenerdiploma.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class StudentDAOImpl implements IStudentDAO{

    private Set<Student> students;

    public StudentDAOImpl(Set<Student> students) {
        loadData();
    }

    @Override
    public Set<Student> findAll() {
        return students;
    }

    @Override
    public boolean save(Student stu) {
        return students.add(stu);
    }

    @Override
    public boolean delete(Long id) {
        return students.removeIf(s->s.getId().equals(id));
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream().filter(s->s.getId().equals(id)).findFirst();
    }

    @Override
    public boolean exists(Student stu) {
        return students.stream().anyMatch(s->s.getId().equals(stu.getId()));
    }

    private void loadData() {
        Set<Student> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<Student>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.students = loadedData;
    }
}
