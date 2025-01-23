package com.melibootcamp.sportsmen.services;

import com.melibootcamp.sportsmen.dtos.PersonDto;
import com.melibootcamp.sportsmen.entities.Person;
import com.melibootcamp.sportsmen.repositories.PersonRepository;
import com.melibootcamp.sportsmen.services.interfaces.IPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements IPersonService {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public PersonServiceImpl(PersonRepository prendaRepository){
        this.modelMapper = new ModelMapper();
        this.personRepository = prendaRepository;
    }

    @Override
    public List<PersonDto> getPeople() {
        List<PersonDto> toReturn = personRepository.findAll().stream()
                .map(x -> modelMapper.map(x, PersonDto.class))
                .collect(Collectors.toList());
        return toReturn;
    }

    @Override
    public boolean savePerson(PersonDto person) {
        try{
            Person toSave = modelMapper.map(person, Person.class);
            personRepository.save(toSave);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deletePerson(long id) {
        try{
            personRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public PersonDto getPersonById(long id) {
        return null;
    }

    @Override
    public boolean updatePerson(long id, PersonDto person) {

        if (!personRepository.existsById(id)){
            return false;
        }

        person.setId(id);
        Person toUpdate = modelMapper.map(person, Person.class);
        personRepository.save(toUpdate);
        return true;
    }
}
