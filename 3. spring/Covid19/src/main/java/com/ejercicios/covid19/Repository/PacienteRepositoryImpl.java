package com.ejercicios.covid19.Repository;

import com.ejercicios.covid19.DTO.PacienteDTO;
import com.ejercicios.covid19.models.Persona;
import com.ejercicios.covid19.models.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteRepositoryImpl implements PacienteRepository {
    private List<PacienteDTO> databasePacientes;
    private final List<Sintoma> databaseSintomas;
    private final List<Persona> databasePersonas;


    public PacienteRepositoryImpl() {
        this.databaseSintomas = loadSintomas();
        this.databasePersonas = loadPersonas();
        this.databasePacientes = loadPacientes();
    }


    private List<Sintoma> loadSintomas() {
        return List.of(
                new Sintoma(1, "A", (int) (Math.random() * 10 + 1)),
                new Sintoma(2, "B", (int) (Math.random() * 10 + 1)),
                new Sintoma(3, "C", (int) (Math.random() * 10 + 1)),
                new Sintoma(4, "D", (int) (Math.random() * 10 + 1)),
                new Sintoma(5, "E", (int) (Math.random() * 10 + 1)),
                new Sintoma(6, "F", (int) (Math.random() * 10 + 1)),
                new Sintoma(7, "G", (int) (Math.random() * 10 + 1)),
                new Sintoma(8, "H", (int) (Math.random() * 10 + 1)),
                new Sintoma(9, "I", (int) (Math.random() * 10 + 1)),
                new Sintoma(10, "J", (int) (Math.random() * 10 + 1))

        );
    }

    private List<Persona> loadPersonas() {

        return List.of(new Persona(1, "A", "A", 33),
                new Persona(2, "B", "B", 67),
                new Persona(3, "C", "C", 20),
                new Persona(4, "D", "D", 82),
                new Persona(5, "E", "E", 55),
                new Persona(6, "F", "F", 47),
                new Persona(7, "G", "G", 73),
                new Persona(8, "H", "H", 90),
                new Persona(9, "I", "I", 18));
    }

    private List<PacienteDTO> loadPacientes() {
        databasePacientes = new ArrayList<>();
        for (Persona p : databasePersonas) {
            List<Sintoma> auxSintomas = new ArrayList<>(databaseSintomas);
            int random = (int) (Math.random() * 3);
            List<Sintoma> sintomas = new ArrayList<>();
            if (random > 0) {
                for (int i = 0; i < random; i++) {
                    auxSintomas.removeAll(sintomas);
                    sintomas.add(auxSintomas.get((int) (Math.random() * auxSintomas.size())));
                }
            }


            databasePacientes.add(new PacienteDTO(p, sintomas));
        }

        return databasePacientes;
    }


    @Override
    public List<Sintoma> findAllSymtom() {
        return databaseSintomas;
    }

    @Override
    public Sintoma findSintomaByName(String name) {
        return databaseSintomas.stream()
                .filter(s -> s.getNombre().equals(name))
                .toList().getFirst();
    }

    @Override
    public List<PacienteDTO> findPacientesByRiskAgeAge() {
        return databasePacientes.stream()
                .filter(pacienteDTO -> pacienteDTO.getPersona().getEdad()>60).toList();
    }

}
