package com.mercadolibre.concesionariodeautos.repository;

import com.mercadolibre.concesionariodeautos.dto.AutoResponseDTO;
import com.mercadolibre.concesionariodeautos.model.Auto;

import java.util.Collection;
import java.util.List;

public interface IAutoRepository extends ICRUDRespository<Auto,Integer> {
    List<Auto> readByDate(Integer since, Integer to);
}
