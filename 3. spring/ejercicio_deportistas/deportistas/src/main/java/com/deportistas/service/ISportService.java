package com.deportistas.service;

import com.deportistas.dto.SportDto;
import com.deportistas.dto.SportLevelDto;
import com.deportistas.dto.SportPersonDto;

import java.util.List;

public interface ISportService {
    List<SportDto> findSports();
    SportLevelDto findSport(String name);
    List<SportPersonDto> findSportPersons();
}
