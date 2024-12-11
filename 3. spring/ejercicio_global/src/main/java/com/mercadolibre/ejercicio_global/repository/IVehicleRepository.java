package com.mercadolibre.ejercicio_global.repository;

import com.mercadolibre.ejercicio_global.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
	List<Vehicle> findAll();
}
