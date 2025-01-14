package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.model.Student;
import com.example.ejemplo_jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;}


    @Override
    @Transactional(readOnly=true)
    public List<Student> getStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    @Transactional(readOnly=true)
    public Student findStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
    @Override
    @Transactional
    public Student updateStudent(Long id, Student student) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id " + id);
        }
        student.setId(id);
        return studentRepository.save(student);
    }

}
