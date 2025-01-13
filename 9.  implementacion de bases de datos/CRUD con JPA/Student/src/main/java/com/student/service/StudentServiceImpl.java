package com.student.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.dto.StudentDTO;
import com.student.model.Student;
import com.student.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public StudentDTO saveStudent(StudentDTO student) {
        Student newStudent = studentRepository.save(objectMapper.convertValue(student, Student.class));
        return objectMapper.convertValue(newStudent, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> objectMapper.convertValue(student, StudentDTO.class)).toList();
    }

    @Override
    public StudentDTO getStudentById(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        return objectMapper.convertValue(student, StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTO student) {
        Student studentToUpdate = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        studentToUpdate.setName(student.getName());
        studentToUpdate.setLastName(student.getLastName());

        Student updatedStudent = studentRepository.save(studentToUpdate);
        return objectMapper.convertValue(updatedStudent, StudentDTO.class);
    }

    @Override
    public String deleteStudent(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.delete(student);
        return "Student deleted";
    }
}
