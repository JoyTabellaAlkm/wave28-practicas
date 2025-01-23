package com.bootcamp.deportes.repository;

import com.bootcamp.deportes.model.Deporte;
import com.bootcamp.deportes.model.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@Repository
public class PersonaRepository {
    private List<Persona> people = List.of(
            new Persona("James", "Rodriguez", 23, new Deporte("Futbol", "Principiante")),
            new Persona("Diego", "Cepeda", 20, new Deporte("Voley", "Intermedio")),
            new Persona("Lucas", "Arango", 30, new Deporte("Futbol", "Intermedio")),
            new Persona("Camila", "Sepulveda", 18, new Deporte("Hockey", "Avanzado"))
    );

    public List<Persona> getAll() {
        return people;
    }
}
