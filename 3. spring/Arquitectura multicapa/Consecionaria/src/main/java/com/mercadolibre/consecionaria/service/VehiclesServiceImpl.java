package com.mercadolibre.consecionaria.service;
import com.mercadolibre.consecionaria.dto.VehiclesDtoResponse;
import com.mercadolibre.consecionaria.dto.VehiclesWithoutServicesDtoResponse;
import com.mercadolibre.consecionaria.entity.Vehicles;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehiclesServiceImpl implements IVehicles{

    Integer id = 1;
    Map<Integer, Vehicles> vehiculos = new HashMap<>();

    @Override
    public VehiclesDtoResponse crearVehiculo(Vehicles vehiculo) {
        vehiculos.put(id, vehiculo);
        id++;
        return vehiculos.entrySet().stream()
                .filter(entry -> entry.getKey().equals(id-1))
                .map(entry -> new VehiclesDtoResponse(
                        entry.getValue().getBrand(),
                        entry.getValue().getModel(),
                        entry.getValue().getManufacturingDte(),
                        entry.getValue().getNumberOfKilometers(),
                        entry.getValue().getDoors(),
                        entry.getValue().getPrice(),
                        entry.getValue().getCurrency(),
                        entry.getValue().getServices(),
                        entry.getValue().getCountOfOwners()
                ))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<VehiclesWithoutServicesDtoResponse> devolverVehiculos() {
        return vehiculos.values().stream()
                .map(entry -> new VehiclesWithoutServicesDtoResponse(
                        entry.getBrand(),
                        entry.getModel(),
                        entry.getManufacturingDte(),
                        entry.getNumberOfKilometers(),
                        entry.getDoors(),
                        entry.getPrice(),
                        entry.getCurrency(),
                        entry.getCountOfOwners()
                ))
                .toList();
    }

    @Override
    public List<VehiclesDtoResponse> devolverVehiculosXFecha(String since, String to) {
        // Convertir las fechas de entrada (String) a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Ajusta el formato según sea necesario
        LocalDate sinceDate = LocalDate.parse(since, formatter);
        LocalDate toDate = LocalDate.parse(to, formatter);
        return vehiculos.values().stream()
                .filter(entry -> {
                    // Convertir la fecha del vehículo (String) a LocalDate
                    LocalDate manufacturingDate = LocalDate.parse(entry.getManufacturingDte(), formatter);
                    return (manufacturingDate.isEqual(sinceDate) || manufacturingDate.isAfter(sinceDate))
                            && (manufacturingDate.isEqual(toDate) || manufacturingDate.isBefore(toDate));
                })
                .map(entry -> new VehiclesDtoResponse(
                        entry.getBrand(),
                        entry.getModel(),
                        entry.getManufacturingDte(),
                        entry.getNumberOfKilometers(),
                        entry.getDoors(),
                        entry.getPrice(),
                        entry.getCurrency(),
                        entry.getServices(),
                        entry.getCountOfOwners()
                ))
                .toList();
    }

    @Override
    public List<VehiclesDtoResponse> devolverVehiculosXPrecio(int since, int to) {
        return vehiculos.values().stream()
                .filter(entry -> Integer.parseInt(entry.getPrice()) >= since && Integer.parseInt(entry.getPrice()) <= to)
                .map(entry -> new VehiclesDtoResponse(
                        entry.getBrand(),
                        entry.getModel(),
                        entry.getManufacturingDte(),
                        entry.getNumberOfKilometers(),
                        entry.getDoors(),
                        entry.getPrice(),
                        entry.getCurrency(),
                        entry.getServices(),
                        entry.getCountOfOwners()
                ))
                .toList();
    }

    @Override
    public VehiclesDtoResponse devolverVehiculoXId(int id) {
        return vehiculos.entrySet().stream()
                .filter(entry -> entry.getKey().equals(id))
                .map(entry -> new VehiclesDtoResponse(
                        entry.getValue().getBrand(),
                        entry.getValue().getModel(),
                        entry.getValue().getManufacturingDte(),
                        entry.getValue().getNumberOfKilometers(),
                        entry.getValue().getDoors(),
                        entry.getValue().getPrice(),
                        entry.getValue().getCurrency(),
                        entry.getValue().getServices(),
                        entry.getValue().getCountOfOwners()
                ))
                .findFirst()
                .orElse(null);

    }
}
