package com.student.service;

import com.student.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    public StudentDTO saveStudent(StudentDTO student);
    public List<StudentDTO> getAllStudents();
    public StudentDTO getStudentById(int id);
    public StudentDTO updateStudent(int id, StudentDTO student);
    public String deleteStudent(int id);
}