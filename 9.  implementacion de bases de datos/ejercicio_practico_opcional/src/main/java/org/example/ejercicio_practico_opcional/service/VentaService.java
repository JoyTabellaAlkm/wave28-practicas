package org.example.ejercicio_practico_opcional.service;

import org.example.ejercicio_practico_opcional.dto.PrendaDTO;
import org.example.ejercicio_practico_opcional.dto.VentaDTO;
import org.example.ejercicio_practico_opcional.exception.VentaNotFoundException;
import org.example.ejercicio_practico_opcional.model.Venta;
import org.example.ejercicio_practico_opcional.repository.VentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Crear una nueva venta
    public VentaDTO createVenta(VentaDTO ventaDTO) {
        Venta venta = modelMapper.map(ventaDTO, Venta.class);
        Venta savedVenta = ventaRepository.save(venta);
        return modelMapper.map(savedVenta, VentaDTO.class);
    }

    // Devolver todas las ventas
    public List<VentaDTO> findAll() {
        List<Venta> ventas = ventaRepository.findAll();
        return ventas.stream()
                .map(venta -> modelMapper.map(venta, VentaDTO.class))
                .collect(Collectors.toList());
    }

    // Devolver una venta particular
    public VentaDTO findByNumber(Long number) {
        Venta venta = ventaRepository.findById(number)
                .orElseThrow(() -> new VentaNotFoundException(number));
        return modelMapper.map(venta, VentaDTO.class);
    }

    // Actualizar una venta particular
    public VentaDTO updateVenta(Long number, VentaDTO ventaDTO) {
        Venta ventaExistente = ventaRepository.findById(number)
                .orElseThrow(() -> new VentaNotFoundException(number)); // Manejo de excepciones

        // Actualizar los campos de venta existente
        modelMapper.map(ventaDTO, ventaExistente);
        Venta updatedVenta = ventaRepository.save(ventaExistente);
        return modelMapper.map(updatedVenta, VentaDTO.class);
    }

    // Eliminar una venta
    public void deleteVenta(Long number) {
        ventaRepository.deleteById(number);
    }

    // Buscar ventas por fecha
    public List<VentaDTO> findByFecha(Date fecha) {
        List<Venta> ventas = ventaRepository.findByFecha(fecha);
        return ventas.stream()
                .map(venta -> modelMapper.map(venta, VentaDTO.class))
                .collect(Collectors.toList());
    }

    // Traer prendas por número de venta
    public List<PrendaDTO> getClothesBySaleNumber(Long number) {
        Venta venta = ventaRepository.findById(number)
                .orElseThrow(() -> new VentaNotFoundException(number));
        return venta.getPrendas().stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .collect(Collectors.toList());
    }
}