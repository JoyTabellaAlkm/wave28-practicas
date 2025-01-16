package com.mercadolibre.siniestros.service;

import java.util.List;
import java.util.Set;

import com.mercadolibre.siniestros.dto.CreateVehicleDto;
import com.mercadolibre.siniestros.dto.PatenteMarcaModeloVehicleDto;
import com.mercadolibre.siniestros.dto.PatenteMarcaVehicleDto;
import com.mercadolibre.siniestros.dto.VehiculoDto;

public interface IVehiculoService {

    public List<VehiculoDto> findAllVehiculos();

    public VehiculoDto saveVehiculo(CreateVehicleDto request);

    public List<String> findAllPatentes();

    public List<PatenteMarcaVehicleDto> findAllPatentesAndMarcasOrderByAnioFabricacion();

    public List<String> findAllPatentesByCantidadRuedasUpAndAnioFabricacionIs(int cantidadRuedas, int anioFabricacion);

    public Set<PatenteMarcaModeloVehicleDto> findAllPatentesMarcaModeloBySiniestroPerdidaEconomicaUp(double perdidaEconomica);

    public Set<List<?>> findAllPatentesMarcaModeloTotalLossBySiniestroPerdidaEconomicaUp(double perdidaEconomica);

}
