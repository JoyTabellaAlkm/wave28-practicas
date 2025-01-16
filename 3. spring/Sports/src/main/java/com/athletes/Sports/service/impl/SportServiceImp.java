package com.athletes.Sports.service.impl;

import com.athletes.Sports.dto.PersonDto;
import com.athletes.Sports.model.Person;
import com.athletes.Sports.model.Sport;
import com.athletes.Sports.service.ISportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportServiceImp implements ISportService {
    private List<Sport> sports = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();

    public SportServiceImp() {
        sports.add(new Sport("tenis", "Facil"));
        Sport futbol = new Sport("futbol", "Dificil");
        Sport natacion = new Sport("Natación", "Medio");
        sports.add(new Sport("patinaje", "Facil"));
        sports.add(futbol);
        sports.add(natacion);

        persons.add(new Person("cristhian","santamaria",25,natacion));
        persons.add(new Person("dayana","rodriguez",39,futbol));

    }

    @Override
    public List<Sport> findAll() {
        return sports;
    }

    @Override
    public String findLevelBySportName(String sportName) {
        return sports.stream()
                .filter(sp -> sp.getName().equals(sportName))
                .findFirst()
                .get().getLevel();
    }

    @Override
    public List<PersonDto> getPersonSport() {
        return persons.stream()
                .map(person -> new PersonDto(person.getName(),person.getLastname(),person.getSport().getName()))
                .toList();
    }
}
