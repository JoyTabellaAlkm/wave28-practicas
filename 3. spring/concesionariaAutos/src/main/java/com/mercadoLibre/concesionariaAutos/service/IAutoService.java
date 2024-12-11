package com.mercadoLibre.concesionariaAutos.service;

import com.mercadoLibre.concesionariaAutos.dto.request.AutoDto;
import com.mercadoLibre.concesionariaAutos.dto.response.AutoDtoResponse;

import java.util.List;

public interface IAutoService {
    public Long agregarAuto (AutoDto autoAAgregar);
    public List<AutoDtoResponse> traerTodosLosAutos();
    public AutoDtoResponse traerPorId(long id);
    public List<AutoDtoResponse> traerPorRangoDePrecios(double since, double to);
    public List<AutoDtoResponse> traerPorRangoDeFechas(String since, String to);
}
