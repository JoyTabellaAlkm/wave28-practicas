package com.mercadolibre.student.service.impl;

import com.mercadolibre.student.entity.Student;
import com.mercadolibre.student.repository.IStudentRepository;
import com.mercadolibre.student.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No existe el estudiante con ID " + id)
        );
    }

    @Override
    public Student update(Long id, Student student) {
        Student existingStudent = findById(id);
        existingStudent.setDni(student.getDni());
        existingStudent.setName(student.getName());
        existingStudent.setLastname(student.getLastname());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(findById(id));
    }
}
