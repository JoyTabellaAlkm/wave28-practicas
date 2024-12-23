package com.starwars.spring.repository;

import com.starwars.spring.entity.Personaje;
import com.starwars.spring.repository.ICrudRepository;

import java.util.ArrayList;

public interface IPersonajeRepository extends ICrudRepository<Personaje> {

    ArrayList<Personaje> findByName(String name);

}
