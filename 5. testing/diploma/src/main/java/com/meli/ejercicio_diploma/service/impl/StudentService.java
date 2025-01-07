package com.meli.ejercicio_diploma.service.impl;

import com.meli.ejercicio_diploma.model.StudentDTO;
import com.meli.ejercicio_diploma.repository.IStudentDAO;
import com.meli.ejercicio_diploma.repository.IStudentRepository;
import com.meli.ejercicio_diploma.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentDAO studentDAO;

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public boolean create(StudentDTO stu) {
        return studentDAO.save(stu);
    }

    @Override
    public StudentDTO read(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public boolean update(StudentDTO stu) {
        return studentDAO.save(stu);
    }

    @Override
    public boolean delete(Long id) {
        return studentDAO.delete(id);
    }

    @Override
    public Set<StudentDTO> getAll() {
        return this.studentRepository.findAll();
    }
}
