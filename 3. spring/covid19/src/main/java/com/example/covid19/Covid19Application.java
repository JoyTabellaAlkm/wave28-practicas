package com.example.covid19;

import com.example.covid19.domain.Person;
import com.example.covid19.domain.Symptom;
import com.example.covid19.repository.PersonRepository;
import com.example.covid19.repository.SymtomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Covid19Application {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SymtomRepository symtomRepository;

    public static void main(String[] args) {
        SpringApplication.run(Covid19Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Symptom symptom1 = new Symptom(1, "tos", "leve");
            Symptom symptom2 = new Symptom(2, "vomito", "medio");
            Symptom symptom3 = new Symptom(3, "sangrado", "grave");

            List<Symptom> symptoms = new ArrayList<>(List.of(symptom1,symptom2,symptom3));

            symtomRepository.add(symptom1);
            symtomRepository.add(symptom2);
            symtomRepository.add(symptom3);

            personRepository.add(new Person(1, "pedro", "gomez", 19, symptoms));
            personRepository.add(new Person(2, "jose", "lopez", 89, symptoms));
        };
    }
}
