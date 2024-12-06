package com.mercadolibre.sports.service;

import com.mercadolibre.sports.model.Sport;

import java.util.List;

public interface ISportsService {

    public List<Sport> findAll();
    public String findLevelBySportName(String sportName);

}
