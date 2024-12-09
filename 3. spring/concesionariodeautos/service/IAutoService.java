package com.mercadolibre.concesionariodeautos.service;

import com.mercadolibre.concesionariodeautos.dto.AutoDTO;
import com.mercadolibre.concesionariodeautos.dto.AutoResponseDTO;
import com.mercadolibre.concesionariodeautos.model.Auto;

import java.util.List;
import java.util.Optional;

public interface IAutoService {
    public List<AutoResponseDTO> readAll();
    public Optional<AutoDTO> readById(Integer id);
    public Auto create(AutoDTO auto);
    public List<AutoResponseDTO> readByDate(Integer since, Integer to);
}
