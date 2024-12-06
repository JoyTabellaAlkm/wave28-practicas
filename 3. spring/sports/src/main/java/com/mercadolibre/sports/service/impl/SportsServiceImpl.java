package com.mercadolibre.sports.service.impl;

import com.mercadolibre.sports.model.Sport;
import com.mercadolibre.sports.service.ISportsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportsServiceImpl implements ISportsService {

    private List<Sport> sports = new ArrayList<>();

    public SportsServiceImpl() {
        sports.add(new Sport("Futbol", "Dificil"));
        sports.add(new Sport("Beisbol", "Dificil"));
        sports.add(new Sport("Natación", "Medio"));
        sports.add(new Sport("ESports", "Facil"));
    }

    @Override
    public List<Sport> findAll() {
        return sports;
    }

    @Override
    public String findLevelBySportName(String sportName) {
        return sports.stream()
                .filter(sp -> sp.getName().equals(sportName))
                .findFirst()
                .get()
                .getLevel();
    }
}
