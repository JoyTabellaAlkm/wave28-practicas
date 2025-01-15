package com.demo.demo.service;

import com.demo.demo.dto.VentaDTO;
import com.demo.demo.model.Venta;
import com.demo.demo.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    private final IVentaRepository repository;
    private final ModelMapper mapper;

    public VentaService(IVentaRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public VentaDTO save(VentaDTO venta) {
        Venta ventaToSave = mapper.map(venta, Venta.class);
        Venta savedVenta = repository.save(ventaToSave);
        return mapper.map(savedVenta, VentaDTO.class);
    }

    @Override
    public List<VentaDTO> findAll() {
        List<Venta> ventas = repository.findAll();
        return mapToDTO(ventas);
    }

    @Override
    public List<VentaDTO> findAllByDate(String date) {
        LocalDate localDate = parseStringToLocalDate(date);
        List<Venta> ventas = repository.findAllByFullDate(localDate);
        return mapToDTO(ventas);
    }

    private List<VentaDTO> mapToDTO(List<Venta> ventas) {
        return ventas.stream()
                .map(v -> mapper.map(v, VentaDTO.class))
                .toList();
    }

    private LocalDate parseStringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Bad date format");
        }
    }
}
