package com.athletes.Sports.service;

import com.athletes.Sports.dto.PersonDto;
import com.athletes.Sports.model.Sport;

import java.util.List;

public interface ISportService {
    public List<Sport> findAll();
    public String findLevelBySportName(String sportName);
    public List<PersonDto> getPersonSport();
}
