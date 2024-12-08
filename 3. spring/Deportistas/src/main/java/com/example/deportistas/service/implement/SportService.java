package com.example.deportistas.service.implement;

import com.example.deportistas.dto.PersonDTO;
import com.example.deportistas.dto.SportDTO;
import com.example.deportistas.service.IPersonService;
import com.example.deportistas.service.ISportService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SportService implements ISportService, IPersonService {
    List<SportDTO> sports;
    List<PersonDTO> people;

    public SportService() {
        sports = new ArrayList<>();
        people = new ArrayList<>();

        sports.add(new SportDTO("Chess", "Advanced"));
        sports.add(new SportDTO("Go", "Beginner"));
        people.add(new PersonDTO("Nicolas", "Arias", "Chess"));
        people.add(new PersonDTO("Mariana", "Ramirez", "Go"));
    }
    @Override
    public  List<SportDTO> getSports(){
        return sports;
    }

    @Override
    public SportDTO getSportByName(String name){
        Optional<SportDTO> sport = sports.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();

        if( sport.isPresent() ) return sport.get();
        else throw new RuntimeException("Sport not found");
    }

    @Override
    public List<PersonDTO> getListPeople(){
        return people;
    }
}
