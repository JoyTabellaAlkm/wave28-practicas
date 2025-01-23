package com.melibootcamp.sportsmen.services.interfaces;

import com.melibootcamp.sportsmen.dtos.SportDto;

import java.util.List;

public interface ISportService {
    List<SportDto> getSports();
    boolean saveSport (SportDto sport);
    boolean deleteSport (long id);
    SportDto getSportById(long id);

    boolean updateSport(long id, SportDto sport);
}
