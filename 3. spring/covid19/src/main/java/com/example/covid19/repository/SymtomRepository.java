package com.example.covid19.repository;

import com.example.covid19.domain.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class SymtomRepository {
    private List<Symptom> symtomList;

    public SymtomRepository() {
        this.symtomList = new ArrayList<>();
    }

    public void add(Symptom symptom) {
        symtomList.add(symptom);
    }

    public List<Symptom> findAll(){
        return symtomList;
    }

    public Symptom findByName(String name) {
        return symtomList.stream().filter(
                        s -> Objects.equals(s.getNombre(), name))
                .findFirst()
                .orElse(null);
    }
}
