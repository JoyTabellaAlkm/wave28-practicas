package com.ar.mercadolibre.deportistas.utils;

import com.ar.mercadolibre.deportistas.models.Person;
import com.ar.mercadolibre.deportistas.models.Sport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BD {

    public static List<Sport> sports;
    public static List<Person> persons;

    public BD() {
        sports = new ArrayList<>();
        sports.add(new Sport("Futbol", "1"));
        sports.add(new Sport("Voleyball", "2"));
        sports.add(new Sport("Rugby", "2"));
        sports.add(new Sport("Tennis", "1"));
        sports.add(new Sport("Bascketball", "3"));

        persons = new ArrayList<>();
        persons.add(new Person("Juan", "Perez", 21));
        persons.add(new Person("Lucia", "Ruiz", 21));
        persons.add(new Person("Ana", "Lopez", 21));
        persons.add(new Person("Luis", "Gimenez", 21));
        persons.add(new Person("Jane", "Doe", 21));
    }

}
