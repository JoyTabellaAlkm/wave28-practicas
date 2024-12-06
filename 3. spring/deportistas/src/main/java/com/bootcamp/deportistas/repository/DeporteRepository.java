package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Deporte;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@Repository
public class DeporteRepository {
    private List<Deporte> sports = List.of(
            new Deporte("Futbol", "Principiante"),
            new Deporte("Voley", "Intermedio"),
            new Deporte("Hockey", "Avanzado")
    );

    public List<Deporte> getAll() {
        return sports;
    }

    public Optional<Deporte> getByName(String sportName) {
        return sports.stream()
                .filter(sport -> sport.getName().equals(sportName))
                .findFirst();
    }
}
