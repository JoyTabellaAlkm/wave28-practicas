package com.ar.mercadolibre.deportistas.services;

import com.ar.mercadolibre.deportistas.dtos.SportDTO;
import com.ar.mercadolibre.deportistas.dtos.SportspersonDTO;
import com.ar.mercadolibre.deportistas.models.Person;
import com.ar.mercadolibre.deportistas.models.Sport;
import com.ar.mercadolibre.deportistas.utils.BD;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{

    public PersonServiceImpl() {
    }

    @Override
    public List<SportspersonDTO> findSportsPersons() {
        List<SportspersonDTO> sportsPersons = new ArrayList<>();
        for(int i = 0; i < BD.sports.size(); i++) {
            Person person = BD.persons.get(i);
            Sport sport = BD.sports.get(i);
            SportspersonDTO sportsPerson = new SportspersonDTO(person.getName(), person.getSurname(), new SportDTO(sport.getName(), sport.getLevel()));
            sportsPersons.add(sportsPerson);
        }

        return sportsPersons;
    }
}
