package com.mercadolibre.Deportistas.services.impl;

import com.mercadolibre.Deportistas.dto.PersonDTO;
import com.mercadolibre.Deportistas.dto.SportDTO;
import com.mercadolibre.Deportistas.dto.response.SportResponseDTO;
import com.mercadolibre.Deportistas.model.Person;
import com.mercadolibre.Deportistas.services.ISportService;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportServiceImpl implements ISportService {
    List<SportDTO> sports;
    List<PersonDTO> persons;

    public SportServiceImpl() {
        this.sports = new ArrayList<>(List.of(
                new SportDTO("Tenis", 2),
                new SportDTO("Futbol", 3),
                new SportDTO("BMX", 1),
                new SportDTO("Motociclismo", 2)
        ));

        this.persons = new ArrayList<>(List.of(
                new PersonDTO("Bryan", "Muñoz", 18, sports.get(0)),
                new PersonDTO("Andres", "Gomez", 22, null),
                new PersonDTO("Juliana", "Cortez", 19, null),
                new PersonDTO("Sofia", "Molina", 26, sports.get(1))
        ));

    }

    @Override
    public List<SportDTO> findSports() {
        return sports;
    }

    @Override
    public SportDTO findSportByName(String name) {
        return sports.stream().filter(sport -> sport.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @Override
    public List<SportResponseDTO> findSportsPersons() {
        List<SportResponseDTO> response = new ArrayList<>();
        persons.stream().filter(personDTO -> personDTO.getSport() != null).forEach(personDTO -> response.add(
                new SportResponseDTO(personDTO.getName(),personDTO.getLastName(),personDTO.getSport().getName())
        ));
        return response;
    }
}
