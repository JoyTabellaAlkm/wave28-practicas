package com.melibootcamp.empresadeseguros.service.interfaces;


import com.melibootcamp.empresadeseguros.dto.MarcaMatriculaModeloDTO;
import com.melibootcamp.empresadeseguros.dto.VehiculoInfoDTO;
import com.melibootcamp.empresadeseguros.entity.Vehiculo;
import java.time.LocalDate;
import java.util.List;

public interface IVehiculoService {
    public List<Vehiculo> getVehiculos();
    public boolean saveVehiculo (Vehiculo vehiculo);
    public Vehiculo getVehiculoById(long id);
    public List<String> getPatentes();
    public List<VehiculoInfoDTO> getPatenteAndMarca();
    public List<MarcaMatriculaModeloDTO> getVehiculosConPerdidaMayorA10000();
    public List<String> findPatentesWhereMasDe4RuedasAndFabricadosEsteAño();
}
