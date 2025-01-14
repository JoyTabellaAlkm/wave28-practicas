package com.melibootcamp.empresadeseguros.service.interfaces;


import com.melibootcamp.empresadeseguros.entity.Vehiculo;
import java.time.LocalDate;
import java.util.List;

public interface IVehiculoService {
    public List<Vehiculo> getVehiculos();
    public boolean saveVehiculo (Vehiculo vehiculo);
    public Vehiculo getVehiculoById(long id);
/*
    public boolean deleteVehiculo (long id);

    public boolean updateVehiculo(long id, Vehiculo vehiculo);
*/
}
