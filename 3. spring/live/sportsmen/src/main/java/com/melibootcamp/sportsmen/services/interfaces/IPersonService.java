package com.melibootcamp.sportsmen.services.interfaces;

import com.melibootcamp.sportsmen.dtos.PersonDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getPeople();
    boolean savePerson (PersonDto person);
    boolean deletePerson (long id);
    PersonDto getPersonById(long id);

    boolean updatePerson(long id, PersonDto person);
}
