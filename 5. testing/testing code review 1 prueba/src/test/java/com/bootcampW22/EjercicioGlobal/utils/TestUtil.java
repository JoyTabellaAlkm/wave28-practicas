package com.bootcampW22.EjercicioGlobal.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.util.ResourceUtils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class TestUtil {

    private TestUtil() {
    }

    public static List<Vehicle> getVehicleList() {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            file = ResourceUtils.getFile("classpath:vehicles_100.json");
            return objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {
            });
        } catch (FileNotFoundException e) {
            return List.of();
        } catch (IOException e) {
            return List.of();
        }
    }

    public static List<Vehicle> getVehicleListByYearAndColor() {
        Vehicle vehicle1 = new Vehicle(1L, "Pontiac", "Fiero", "6603", "Green", 1986, "85", 2, "gasoline",
                "semi-automatic", 105.43, 280.28, 288.8);
        Vehicle vehicle2 = new Vehicle(2L, "Ferrari", "296 GTB", "6604", "Green", 1986, "105", 2, "gasoline",
                "semi-automatic", 105.43, 280.28, 288.8);
        return List.of(vehicle1, vehicle2);
    }

    public static List<Vehicle> getVehicleListByYearAndColorIntegration() {
        Vehicle vehicle1 = new Vehicle(83L, "Plymouth", "Neon", "8", "Red", 2000, "112", 4, "gasoline",
                "semi-automatic", 127.58, 91.99, 243.35);
        return List.of(vehicle1);
    }

    public static List<Vehicle> getVehicleListByBrandAndRangeOfYear() {
        Vehicle vehicle1 = new Vehicle(1L, "Ferrari", "SF90 Spider", "6603", "Red", 2007, "140", 4, "gasoline",
                "automatic", 125.43, 340.28, 300.8);
        Vehicle vehicle2 = new Vehicle(2L, "Ferrari", "296 GTB", "6604", "Green", 2004, "105", 2, "gasoline",
                "semi-automatic", 105.43, 280.28, 288.8);
        return List.of(vehicle1, vehicle2);
    }

    public static List<Vehicle> getVehicleListByBrandAndRangeOfYearIntegration() {
        Vehicle vehicle1 = new Vehicle(224L, "Ferrari", "California", "4302", "Violet", 2009, "196", 1, "biodiesel",
                "semi-automatic", 239.4, 200.35, 242.29);

        return List.of(vehicle1);
    }

    public static List<Vehicle> getVehicleListByRangeOfWeight() {
        Vehicle vehicle1 = new Vehicle(1L, "Lamborghini", "Gallardo", "6603", "Red", 2007, "140", 4, "gasoline",
                "automatic", 125.43, 340.28, 300.8);
        Vehicle vehicle2 = new Vehicle(2L, "Lamborghini", "296 GTB", "6604", "Green", 2004, "105", 2, "gasoline",
                "semi-automatic", 105.43, 280.28, 288.8);
        return List.of(vehicle1, vehicle2);
    }

    public static List<Vehicle> getVehicleListByRangeOfWeightIntegration() {
        Vehicle vehicle1 = new Vehicle(341L, "Maserati", "Biturbo", "2", "Pink", 1985, "234", 4, "gasoline",
                "automatic", 254.21, 58.42, 299.95);
        Vehicle vehicle2 = new Vehicle(413L, "Toyota", "Solara", "7504", "Green", 2004, "115", 2, "biodiesel",
                "semi-automatic", 131.13, 202.01, 299.68);
        return List.of(vehicle1, vehicle2);
    }

    public static List<Vehicle> getVehicleListByBrand() {
        Vehicle vehicle1 = new Vehicle(1L, "Ferrari", "SF90 Spider", "6603", "Red", 2007, "140", 4, "gasoline",
                "automatic", 125.43, 340.28, 300.8);
        Vehicle vehicle2 = new Vehicle(2L, "Ferrari", "296 GTB", "6604", "Green", 2004, "105", 2, "gasoline",
                "semi-automatic", 105.43, 280.28, 288.8);
        return List.of(vehicle1, vehicle2);
    }

    public static List<Vehicle> getVehicleListEmpty() {
        return List.of();
    }

    public static List<VehicleDto> getVehicleDtoList(List<Vehicle> vehicleList) {
        ObjectMapper objectMapper = new ObjectMapper();
        return vehicleList.stream().map(v -> {
            return objectMapper.convertValue(v, VehicleDto.class);
        }).toList();
    }

}
