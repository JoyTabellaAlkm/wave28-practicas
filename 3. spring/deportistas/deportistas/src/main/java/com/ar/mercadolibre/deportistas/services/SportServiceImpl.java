package com.ar.mercadolibre.deportistas.services;

import com.ar.mercadolibre.deportistas.dtos.SportDTO;
import com.ar.mercadolibre.deportistas.models.Sport;
import com.ar.mercadolibre.deportistas.utils.BD;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SportServiceImpl implements ISportService{

    public SportServiceImpl() {
    }

    @Override
    public List<SportDTO> findSports() {
        return BD.sports.stream().map(sport -> new SportDTO(sport.getName(), sport.getLevel())).toList();
    }

    @Override
    public String getLevelBySportName(String name) {
        Optional<Sport> sport = BD.sports.stream().filter(s -> s.getName().equals(name)).findFirst();

        return sport.map(Sport::getLevel).orElse(null);
    }
}
