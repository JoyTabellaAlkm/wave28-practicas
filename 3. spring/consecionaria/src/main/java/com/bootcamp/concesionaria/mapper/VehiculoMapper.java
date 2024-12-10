package com.bootcamp.concesionaria.mapper;

import com.bootcamp.concesionaria.dto.VehiculoDTO;
import com.bootcamp.concesionaria.dto.VehiculoUsadoDTO;
import com.bootcamp.concesionaria.model.Vehiculo;
import com.bootcamp.concesionaria.util.DateUtils;

import java.util.Date;

public class VehiculoMapper {
    private VehiculoMapper() {}

    public static Vehiculo from(VehiculoDTO dto) {
        return new Vehiculo(
                null,
                dto.getBrand(),
                dto.getModel(),
                DateUtils.localDateFrom(dto.getManufacturingDate()),
                dto.getKilometers(),
                dto.getDoors(),
                dto.getPrice(),
                dto.getCurrency(),
                dto.getServices().stream().map(ServiceMapper::from).toList(),
                dto.getCountOfOwners()
        );
    }

    public static VehiculoUsadoDTO toVehiculoUsadoDTO(Vehiculo vehiculo) {
        return new VehiculoUsadoDTO(
                vehiculo.getBrand(),
                vehiculo.getModel(),
                DateUtils.toString(vehiculo.getManufacturingDate()),
                vehiculo.getKilometers(),
                vehiculo.getDoors(),
                vehiculo.getPrice(),
                vehiculo.getCurrency(),
                vehiculo.getCountOfOwners()
        );
    }

    public static VehiculoDTO toVehiculoDTO(Vehiculo v) {
        return new VehiculoDTO(
                v.getBrand(),
                v.getModel(),
                DateUtils.toString(v.getManufacturingDate()),
                v.getKilometers(),
                v.getDoors(),
                v.getPrice(),
                v.getCurrency(),
                v.getServices().stream().map(ServiceMapper::toServiceDTO).toList(),
                v.getCountOfOwners()
        );
    }
}
