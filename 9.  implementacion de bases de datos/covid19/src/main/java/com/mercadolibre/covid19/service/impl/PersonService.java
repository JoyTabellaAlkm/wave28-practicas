package com.mercadolibre.covid19.service.impl;

import com.mercadolibre.covid19.model.Person;
import com.mercadolibre.covid19.repository.IPersonRepository;
import com.mercadolibre.covid19.service.IPersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    private final IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Id no existe")
        );
    }

    @Override
    public Person update(Person person, Long id) {
        Person personToUpdate = findById(id);

        personToUpdate.setFirstname(person.getFirstname());
        personToUpdate.setLastname(person.getLastname());
        personToUpdate.setAge(person.getAge());
        personToUpdate.setVaccines(person.getVaccines());
        personToUpdate.setSymptoms(person.getSymptoms());

        return personRepository.save(personToUpdate);
    }

    @Override
    public void delete(Long id) {
        Person personToDelete = findById(id);

        personRepository.delete(personToDelete);
    }
}
