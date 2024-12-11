package com.mercadoLibre.concesionariaAutos.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadoLibre.concesionariaAutos.dto.response.AutoDtoResponse;
import com.mercadoLibre.concesionariaAutos.model.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoRepositoryImpl implements IAutoRepository {
    @Autowired
    private ObjectMapper objectMapper;

    private List<Auto> listaAutos;

    public AutoRepositoryImpl() {
        this.listaAutos = new ArrayList<>();
    }

    @Override
    public Long agregarAuto(Auto autoAAgregar) {
        listaAutos.add(autoAAgregar);
        return autoAAgregar.getId();
    }

    @Override
    //brand, model, manufacturingDate, numberOfKilometers, doors, price, currency, countOfOwners
    public List<Auto> traerTodosLosAutos() {
        return listaAutos;
    }

    @Override
    public Auto traerPorId(long id) {
        return listaAutos.stream().filter(a-> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Auto> traerPorRangoDePrecios(double since, double to) {
        return listaAutos.stream().filter(a->Double.parseDouble(a.getPrice())>since && Double.parseDouble(a.getPrice())<to).toList();
    }

    @Override
    public List<Auto> traerPorRangoDeFechas(LocalDate since, LocalDate to) {
        List<Auto> listaEncontrados = listaAutos.stream().filter(v->{
                    System.out.println(v.getManufacturingDate());
                    LocalDate fechaFabricacion = LocalDate.parse(v.getManufacturingDate());
                    System.out.println(fechaFabricacion);
                    System.out.println(since);
                    System.out.println(to);
                    if (fechaFabricacion.isAfter(since) && fechaFabricacion.isBefore(to))
                        return true;
                    return false;
                    }
                ).toList();
        return listaEncontrados;
    }
}
