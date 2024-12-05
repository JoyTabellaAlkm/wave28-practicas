package com.example.covid19.service;

import com.example.covid19.domain.Symptom;
import com.example.covid19.repository.SymtomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymtomService {
    @Autowired
    private SymtomRepository symtomRepository;

    public List<Symptom> findAllSymptom(){
        return symtomRepository.findAll();
    }

    public Symptom findByName(String name) {
        return symtomRepository.findByName(name);
    }
}
