package com.example.concecionaria.service;

import com.example.concecionaria.dto.VehiclesDto;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionarioService {

    List<VehiclesDto> getProducts();

    List<VehiclesDto> getProductsByDateOfCreation(LocalDate since, LocalDate to);

    List<VehiclesDto> getProductsByPrice(int since, int to);

}
