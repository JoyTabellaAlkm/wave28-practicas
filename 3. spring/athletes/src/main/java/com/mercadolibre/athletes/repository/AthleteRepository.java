package com.mercadolibre.athletes.repository;

import com.mercadolibre.athletes.model.Person;
import com.mercadolibre.athletes.model.Sport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AthleteRepository {
    private final List<Person> persons;
    private final List<Sport> sports;

    public AthleteRepository() {
        persons = new ArrayList<>();
        sports = new ArrayList<>();
        fillData();
    }

    public List<Sport> findAllSports(){
        return sports;
    }

    public Optional<Sport> findSportByName(String name) {
        return sports.stream()
                .filter( sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Person> findSportPersons(){
        return persons;
    }

    private void fillData() {

        sports.add(new Sport("Football", 4));
        sports.add(new Sport("Tennis", 3));
        sports.add(new Sport("Swimming", 1));
        sports.add(new Sport("Basketball", 5));
        sports.add(new Sport("Running", 3));
        sports.add(new Sport("Cycling", 2));

        persons.add(new Person("John", "Doe", 30, List.of(sports.get(0), sports.get(2))));
        persons.add(new Person("Jane", "Smith", 25, List.of(sports.get(1))));
        persons.add(new Person("Alice", "Johnson", 22, List.of(sports.get(3), sports.get(4))));
        persons.add(new Person("Bob", "Brown", 35, List.of(sports.get(0), sports.get(5))));
        persons.add(new Person("Charlie", "Davis", 28, List.of(sports.get(4))));
        persons.add(new Person("Emily", "Clark", 20, List.of(sports.get(2), sports.get(3))));
        persons.add(new Person("Daniel", "Garcia", 40, List.of(sports.get(1), sports.get(0))));
        persons.add(new Person("Sophia", "Martinez", 18, List.of(sports.get(5))));
        persons.add(new Person("Lucas", "Wilson", 27, List.of(sports.get(0), sports.get(1))));
        persons.add(new Person("Olivia", "Anderson", 33, List.of(sports.get(2), sports.get(4), sports.get(5))));

    }
}
