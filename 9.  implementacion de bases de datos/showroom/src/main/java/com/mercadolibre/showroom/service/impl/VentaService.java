package com.mercadolibre.showroom.service.impl;

import com.mercadolibre.showroom.dto.PrendaDto;
import com.mercadolibre.showroom.dto.VentaDto;
import com.mercadolibre.showroom.model.Prenda;
import com.mercadolibre.showroom.model.Venta;
import com.mercadolibre.showroom.repository.IVentaRepository;
import com.mercadolibre.showroom.service.IVentaService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    private final ModelMapper mapper;

    private final IVentaRepository ventaRepository;

    public VentaService(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
        this.mapper= new ModelMapper();
    }

    @Override
    public Integer generarNuevaVenta(VentaDto ventaDto) {
        return ventaRepository.save(mapper.map(ventaDto, Venta.class)).getNumero();
    }

    @Override
    public List<VentaDto> obtenerVentas() {
        return ventaRepository.findAll()
                .stream().map(venta ->
                        mapper.map(venta, VentaDto.class))
                .toList();
    }

    @Override
    public VentaDto obtenerVenta(Integer numero) {
        return mapper.map(ventaRepository.findById(numero), VentaDto.class);
    }

    @Override
    public VentaDto actualizarVenta(Integer numero, VentaDto ventaDto) {
        Venta venta = ventaRepository.findById(numero)
                .orElseThrow(() -> new EntityNotFoundException("Prenda con código " + numero + " no encontrada."));;
        mapper.map(ventaDto,venta);
        return mapper.map(ventaRepository.save(venta), VentaDto.class);
    }

    @Override
    public void eliminarVenta(Integer numero) {
        ventaRepository.deleteById(numero);
    }

    @Override
    public List<VentaDto> obtenerVentasXFecha(LocalDate fecha) {
        return ventaRepository.findAllByFecha(fecha)
                .stream().map(venta ->
                        mapper.map(venta, VentaDto.class))
                .toList();
    }

    @Override
    public List<PrendaDto> obtenerPrendasXVenta(Integer numero) {
        Venta venta = ventaRepository.findById(numero)
                .orElseThrow(() -> new EntityNotFoundException("Prenda con código " + numero + " no encontrada."));

        return venta.getPrendas().stream()
                .map(prenda->mapper.map(prenda,PrendaDto.class))
                .toList();
    }
}
