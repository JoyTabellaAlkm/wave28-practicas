package com.ejercicio.autos.Service;

import com.ejercicio.autos.DTO.UsadosDTO;
import com.ejercicio.autos.DTO.VehiculoDTO;

import java.time.LocalDate;
import java.util.List;

public interface iVehiculoService {
    public Boolean agregarVehiculo(VehiculoDTO vehiculo);

    public List<UsadosDTO> retornarUsados();

    public List<VehiculoDTO> retornarUsadosFecha(LocalDate since, LocalDate to);

    public List<VehiculoDTO> retornarUsadosPrecio(double since, double to);

    public VehiculoDTO buscarVehiculoID(int id);
}
