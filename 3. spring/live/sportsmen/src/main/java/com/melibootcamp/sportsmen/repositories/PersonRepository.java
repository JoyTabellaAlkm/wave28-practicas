package com.melibootcamp.sportsmen.repositories;

import com.melibootcamp.sportsmen.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
