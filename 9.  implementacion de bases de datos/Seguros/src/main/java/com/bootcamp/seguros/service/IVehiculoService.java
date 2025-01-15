package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.VehiculoPatenteMarcaModeloDTO;
import com.bootcamp.seguros.dto.VehiculoPatenteMarcaModeloTotalDTO;
import com.bootcamp.seguros.dto.VehiculoPatenteMarcaModeloTotalResponseDTO;
import com.bootcamp.seguros.dto.VehiculoPatenteYMarcaDTO;

import java.util.List;

public interface IVehiculoService {
    List<String> findAllPatentes();
    List<VehiculoPatenteYMarcaDTO> findByPatentesyMarcasSortedByAnio();
    List<String> findByPatenteFilterByFourRuedasAndCurrentAnio();
    List<VehiculoPatenteMarcaModeloDTO> findBySiniestroConPerdidaMayorA10000();
    VehiculoPatenteMarcaModeloTotalResponseDTO findBySiniestroConPerdidaMayorA10000AndPerdidaTotal();
}
