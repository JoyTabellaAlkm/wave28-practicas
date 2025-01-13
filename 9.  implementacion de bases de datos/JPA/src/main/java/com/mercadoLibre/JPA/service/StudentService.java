package com.mercadoLibre.JPA.service;


import com.mercadoLibre.JPA.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }
}
