package com.bootcamp.SegurosAutos.service;

import com.bootcamp.SegurosAutos.dto.PatenteMarcaDto;
import com.bootcamp.SegurosAutos.dto.PatentesDto;
import com.bootcamp.SegurosAutos.dto.VehiculoDto;

import java.util.List;

public interface IVehiculoService {
    void post(VehiculoDto dto);
    List<VehiculoDto> getAll();
    PatentesDto patentes();
    List<PatenteMarcaDto> patentesMarcasOrdenadasPorFechaFabricacion();
    List<PatenteMarcaDto> patentesMarcasMasDeCuatroRuedasFabricadosEsteAnio();
}
