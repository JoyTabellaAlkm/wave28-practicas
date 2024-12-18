package com.ejercicios.calorias.services.interfaces;

import com.ejercicios.calorias.dto.DishDTO;
import com.ejercicios.calorias.dto.response.ResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IFoodService {
    public ResponseDTO calculate(DishDTO dish);
}
