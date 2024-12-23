package com.starwars.spring.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.starwars.spring.entity.Personaje;
import com.starwars.spring.repository.IPersonajeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository {

    private ArrayList<Personaje> personajes;

    public PersonajeRepository() {
        System.out.println("Se esta inicializando el repository");
        this.personajes = loadData();
    }

    @Override
    public Personaje save(Personaje personaje) {
        // Si el nuevo personaje se agrego, devolver el mismo parametro

        // Asigno un nuevo id en base al tamaño actual de la lista
        personaje.setId(personajes.size());

        // añado
        if(this.personajes.add(personaje))
            return personaje;
        // else
        //   aca retorno el error, pero todavia no vimos excepciones. Devuelvo null por el momento.
        return null;
    }

    @Override
    public Personaje update(Personaje personaje) {

        var id = this.personajes.indexOf(personaje);

        if(id != -1) {
            this.personajes.set(id, personaje);
            return personaje;
        }

        // else
        //   aca retorno el error, pero todavia no vimos excepciones. Devuelvo null por el momento.

        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return this.personajes.removeIf(personaje -> personaje.getId().equals(id));
    }

    @Override
    public Optional<Personaje> findById(Integer id) {

        return this.personajes.stream()
                .filter(personaje -> personaje.getId().equals(id))
                .findFirst();
    }

    @Override
    public ArrayList<Personaje> findAll() {
        return this.personajes;
    }

    @Override
    public ArrayList<Personaje> findByName(String name) {
        return this.personajes.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Personaje> loadData() {
        ArrayList<Personaje> data = null;
        File file;

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<ArrayList<Personaje>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/starwars.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
