package com.deportistas.repository.impl;

import com.deportistas.model.Sport;
import com.deportistas.repository.ISportRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SportRepository implements ISportRepository {
    private List<Sport> entities = new ArrayList<>(List.of(
            new Sport(1,"basket","medio"),
            new Sport(2, "futbol", "alto"),
            new Sport(3, "snowboard", "alto"),
            new Sport(4, "natacion", "bajo")
    ));

    public List<Sport> findAll() {
        return entities;
    }
}
