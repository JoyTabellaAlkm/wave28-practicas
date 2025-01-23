package com.melibootcamp.sportsmen.services;

import com.melibootcamp.sportsmen.dtos.SportDto;
import com.melibootcamp.sportsmen.dtos.SportDto;
import com.melibootcamp.sportsmen.entities.Sport;
import com.melibootcamp.sportsmen.repositories.SportRepository;
import com.melibootcamp.sportsmen.services.interfaces.ISportService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SportServiceImpl implements ISportService {
    private final SportRepository sportRepository;
    private final ModelMapper modelMapper;

    public SportServiceImpl(SportRepository prendaRepository){
        this.modelMapper = new ModelMapper();
        this.sportRepository = prendaRepository;
    }

    @Override
    public List<SportDto> getSports() {
        List<SportDto> toReturn = sportRepository.findAll().stream()
                .map(x -> modelMapper.map(x, SportDto.class))
                .collect(Collectors.toList());
        return toReturn;
    }

    @Override
    public boolean saveSport(SportDto sport) {
        try{
            Sport toSave = modelMapper.map(sport, Sport.class);
            sportRepository.save(toSave);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteSport(long id) {
        try{
            sportRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public SportDto getSportById(long id) {
        return null;
    }

    @Override
    public boolean updateSport(long id, SportDto sport) {

        if (!sportRepository.existsById(id)){
            return false;
        }

        sport.setId(id);
        Sport toUpdate = modelMapper.map(sport, Sport.class);
        sportRepository.save(toUpdate);
        return true;
    }
}
