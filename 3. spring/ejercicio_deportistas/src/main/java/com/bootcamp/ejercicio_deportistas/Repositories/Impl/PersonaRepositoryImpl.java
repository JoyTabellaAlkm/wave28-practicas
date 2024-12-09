package com.bootcamp.ejercicio_deportistas.Repositories.Impl;

import com.bootcamp.ejercicio_deportistas.Models.Deporte;
import com.bootcamp.ejercicio_deportistas.Models.Persona;
import com.bootcamp.ejercicio_deportistas.Repositories.IPersonaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements IPersonaRepository {
    List<Persona> listaPersonas = List.of(
            new Persona(1, "Nico", "Dias", 24, new Deporte(1, "futbol", "media")),
            new Persona(1, "Julian", "Alvarez", 22, new Deporte(1, "futbol", "media")),
            new Persona(1, "Roger", "Federer", 43, new Deporte(1, "futbol", "media")),
            new Persona(1, "Adolfo", "Cambiaso", 49, new Deporte(3, "polo", "alta"))
    );

    @Override
    public void guardar(Persona props) {
        listaPersonas.add(props);
    }

    @Override
    public Persona buscarPorId(Integer id) {
        Persona persona =
                listaPersonas.stream().filter(per -> per.getId() == id).findFirst().get();
        if (persona == null) {
            throw new RuntimeException("Persona no encontrado");
        }
        return persona;
    }

    @Override
    public List<Persona> buscartodos() {
        return listaPersonas;
    }

    @Override
    public void eliminar(Integer id) {
        boolean encontrado = false;
        for (Persona persona : listaPersonas) {
            if (persona.getId() == id) {
                listaPersonas.remove(persona);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new RuntimeException("Persona no encontrado");
        }
    }
}
