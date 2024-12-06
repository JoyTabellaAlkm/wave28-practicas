package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@Repository
public class PersonaRepository {
    private List<Persona> people = List.of(
            new Persona("Luis", "Perez", 23, new Deporte("Futbol", "Principiante")),
            new Persona("Mario", "Lopez", 25, new Deporte("Voley", "Intermedio")),
            new Persona("Julia", "Venegas", 43, new Deporte("Hockey", "Avanzado"))
    );

    public List<Persona> getAll() {
        return people;
    }
}
