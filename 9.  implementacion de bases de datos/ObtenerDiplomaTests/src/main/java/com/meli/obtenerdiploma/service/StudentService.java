package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.Student;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    //@Autowired
    //IStudentDAO studentDAO;

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public Student create(Student stu) {
        return studentRepository.save(stu);
    }

    @Override
    public Student read(Long id) {
        return studentRepository.findById(id).orElse(null);
        //return studentDAO.findById(id);
    }

    @Override
    public Student update(Student stu) {
        //studentDAO.save(stu);
        return null;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
        //studentDAO.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
