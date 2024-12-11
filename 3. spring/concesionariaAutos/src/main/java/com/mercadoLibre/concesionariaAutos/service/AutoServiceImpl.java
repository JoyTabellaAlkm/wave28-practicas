package com.mercadoLibre.concesionariaAutos.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadoLibre.concesionariaAutos.dto.request.AutoDto;
import com.mercadoLibre.concesionariaAutos.dto.response.AutoDtoResponse;
import com.mercadoLibre.concesionariaAutos.model.Auto;
import com.mercadoLibre.concesionariaAutos.repository.IAutoRepository;
import com.mercadoLibre.concesionariaAutos.model.ServiceEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutoServiceImpl implements IAutoService{
    final IAutoRepository autoRepository;
    final ObjectMapper mapper = new ObjectMapper();

    public AutoServiceImpl(IAutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public Long agregarAuto(AutoDto autoAAgregarDto) {
        //Auto auto = mapper.convertValue(autoAAgregarDto, Auto.class);
        Auto auto = new Auto(
                autoAAgregarDto.getBrand(),
                autoAAgregarDto.getModel(),
                autoAAgregarDto.getManufacturingDate(),
                autoAAgregarDto.getNumberOfKilometers(),
                autoAAgregarDto.getDoors(),
                autoAAgregarDto.getPrice(),
                autoAAgregarDto.getCurrency(),
                autoAAgregarDto.getServices().stream()
                        .map(s -> new ServiceEntity(s.getDate(), s.getKilometers(), s.getDescriptions()))
                        .toList(),
                autoAAgregarDto.getCountOfOwners()
        );

        return autoRepository.agregarAuto(auto);
    }

    @Override
    public List<AutoDtoResponse> traerTodosLosAutos() {
        List<Auto> listaEncontrada = autoRepository.traerTodosLosAutos();

        List<AutoDtoResponse> listaAutosDtoResponse = listaEncontrada.stream().map(a ->
                new AutoDtoResponse(
                        a.getBrand(),
                        a.getModel(),
                        a.getManufacturingDate(),
                        a.getNumberOfKilometers(),
                        a.getDoors(),
                        a.getPrice(),
                        a.getCurrency(),
                        a.getCountOfOwners()
                ))
                .toList();

        return listaAutosDtoResponse;
    }

    @Override
    public AutoDtoResponse traerPorId(long id) {
        Auto autoEncontrado = autoRepository.traerPorId(id);
        AutoDtoResponse autoEncontradoResponse = new AutoDtoResponse(
                autoEncontrado.getBrand(),
                autoEncontrado.getModel(),
                autoEncontrado.getManufacturingDate(),
                autoEncontrado.getNumberOfKilometers(),
                autoEncontrado.getDoors(),
                autoEncontrado.getPrice(),
                autoEncontrado.getCurrency(),
                autoEncontrado.getCountOfOwners()
        );

        return autoEncontradoResponse;
    }

    @Override
    public List<AutoDtoResponse> traerPorRangoDePrecios(double since, double to) {
        List<Auto> listaEncontrada = autoRepository.traerPorRangoDePrecios(since, to);

        List<AutoDtoResponse> listaAutosDtoResponse = listaEncontrada.stream().map(a ->
                        new AutoDtoResponse(
                                a.getBrand(),
                                a.getModel(),
                                a.getManufacturingDate(),
                                a.getNumberOfKilometers(),
                                a.getDoors(),
                                a.getPrice(),
                                a.getCurrency(),
                                a.getCountOfOwners()
                        ))
                .toList();

        return listaAutosDtoResponse;
    }

    @Override
    public List<AutoDtoResponse> traerPorRangoDeFechas(String since, String to) {
        LocalDate fechaDesde = LocalDate.parse(since);
        LocalDate fechaHasta = LocalDate.parse(to);

        List<Auto> listaEncontrada = autoRepository.traerPorRangoDeFechas(fechaDesde, fechaHasta);

        List<AutoDtoResponse> listaAutosDtoResponse = listaEncontrada.stream().map(a ->
                        new AutoDtoResponse(
                                a.getBrand(),
                                a.getModel(),
                                a.getManufacturingDate(),
                                a.getNumberOfKilometers(),
                                a.getDoors(),
                                a.getPrice(),
                                a.getCurrency(),
                                a.getCountOfOwners()
                        ))
                .toList();

        return listaAutosDtoResponse;
    }
}
