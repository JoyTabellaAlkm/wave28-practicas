package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.model.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> getStudents();
    public Student findStudent(Long id);
    public void deleteStudent(Long id);
    public void saveStudent(Student student);
    public Student updateStudent(Long id, Student student);
}
