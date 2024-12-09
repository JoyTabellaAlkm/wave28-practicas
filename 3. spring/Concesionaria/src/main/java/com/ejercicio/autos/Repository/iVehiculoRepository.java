package com.ejercicio.autos.Repository;

import com.ejercicio.autos.Model.Vehiculo;

import java.time.LocalDate;
import java.util.List;

public interface iVehiculoRepository {
    public Boolean agregarVehiculo(Vehiculo vehiculo);

    public List<Vehiculo> retornarUsados();

    public List<Vehiculo> retornarVehiculosFechas(LocalDate since, LocalDate to);

    public List<Vehiculo> retornarVehiculosPrecios(double since, double to);

    public Vehiculo buscarVehiculoID(int id);
}
