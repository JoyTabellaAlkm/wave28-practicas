package com.mercadoLibre.concesionariaAutos.repository;

import com.mercadoLibre.concesionariaAutos.dto.response.AutoDtoResponse;
import com.mercadoLibre.concesionariaAutos.model.Auto;

import java.time.LocalDate;
import java.util.List;

public interface IAutoRepository {
    public Long agregarAuto(Auto autoAAgregar);
    public List<Auto> traerTodosLosAutos();
    public Auto traerPorId(long id);
    public List<Auto> traerPorRangoDePrecios(double since, double to);
    public List<Auto> traerPorRangoDeFechas(LocalDate since, LocalDate to);
}
