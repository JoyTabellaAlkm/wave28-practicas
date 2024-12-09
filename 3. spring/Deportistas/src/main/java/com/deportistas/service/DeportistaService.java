package com.deportistas.service;

import com.deportistas.model.Deportista;
import com.deportistas.model.DeportistaDTO;
import com.deportistas.model.Persona;
import com.deportistas.model.PersonaDTO;

import java.util.ArrayList;
import java.util.List;

public class DeportistaService implements IDeportistaService<DeportistaDTO, PersonaDTO>{

    List<Persona> personaList = new ArrayList<Persona>();

    public DeportistaService() {
        new Deportista("hola", "adios");
        Deportista newDeporte1 = new Deportista("Futboll", "Nivel 4");
        Deportista newDeporte2 = new Deportista("Pole Dance", "Nivel 5");
        Deportista newDeporte3 = new Deportista("Danza", "Nivel 3");

        List<Deportista> deportes1 = new ArrayList<>();
        deportes1.add(newDeporte1);
        deportes1.add(newDeporte3);

        List<Deportista> deportes2 = new ArrayList<>();;
        deportes2.add(newDeporte2);

        Persona newPersona1 = new Persona("Juan","Gabriel",22,deportes1);
        Persona newPersona2 = new Persona("Meli","Marquez",26,deportes2);

        personaList.add(newPersona1);
        personaList.add(newPersona2);
    }

    @Override
    public List<DeportistaDTO> findAllSports() {

        List<DeportistaDTO> allSports = new ArrayList<>();
        personaList.stream().forEach(p ->
                p.getDeportes().stream().forEach(d ->
                        allSports.add(new DeportistaDTO(d.getNombre(), d.getNivel()))));

        return allSports;
        /*List<String> allSportsString = new ArrayList<>();
        personaList.stream().forEach(p ->
                p.getDeportes().stream().forEach(d ->
                        allSports.add(d.getNombre() + " - " + d.getNivel())));

        return allSports.toString();*/
    }

    @Override
    public List<DeportistaDTO> findByName(String name) {
        List<DeportistaDTO> allSports = new ArrayList<>();
        for (Persona persona : personaList) {
            if (persona.getNombre().equals(name)) {
                persona.getDeportes().stream().forEach(d ->
                        allSports.add(new DeportistaDTO(d.getNombre(), d.getNivel())));
            }
        }

        return allSports;
    }

    @Override
    public List<PersonaDTO> findAllPersons() {
        List<PersonaDTO> allPersons = new ArrayList<>();
        personaList.stream().forEach(p ->
                allPersons.add(new PersonaDTO(p.getNombre(), p.getApellido(), p.getEdad(), p.getDeportes())));
        return allPersons;
    }
}
