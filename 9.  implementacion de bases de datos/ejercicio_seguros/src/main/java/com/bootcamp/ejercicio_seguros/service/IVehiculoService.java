package com.bootcamp.ejercicio_seguros.service;

import com.bootcamp.ejercicio_seguros.dto.*;
import com.bootcamp.ejercicio_seguros.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoDTO> listarTodos();
    List<String> listarPatentes();
    List<VehiculoPatenteMarcaDTO> listarPatentesMarcasOrdenadasPorAnio();
    List<String> listarVehiculosPorRuedasYAnio(int cantidadRuedas, int anio);

    List<VehiculoPatenteMarcaModeloDTO> listarVehiculosConPerdidaMayor(double cantidad);

    ListaVehiculoSiniestroDTO listarVehiculosConPerdidaMayorTotalPerdida(double cantidad);
}
