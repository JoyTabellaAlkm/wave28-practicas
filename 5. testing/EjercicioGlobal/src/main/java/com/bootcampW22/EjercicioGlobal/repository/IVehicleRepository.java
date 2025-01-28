package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    List<Vehicle> findVehiclesByYearAndColor(String color, int year);
    List<Vehicle> findVehiclesByBrandAndRangeOfYear(String brand, int start_year, int end_year);
    List<Vehicle> findVehiclesByBrand(String brand);
    List<Vehicle> findVehiclesByRangeOfWeight(double weight_min, double weight_max);

}
