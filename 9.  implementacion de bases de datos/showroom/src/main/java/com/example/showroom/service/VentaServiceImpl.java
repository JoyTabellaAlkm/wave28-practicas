package com.example.showroom.service;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.VentaDto;
import com.example.showroom.entity.Prenda;
import com.example.showroom.entity.Venta;
import com.example.showroom.repository.PrendaRepository;
import com.example.showroom.repository.VentaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
    PrendaRepository prendaRepository;

    VentaRepository ventaRepository;
    private final ModelMapper mapper;
    public VentaServiceImpl(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
    }

    @Override
    public Long postVenta(VentaDto ventaDto) {
        Venta ventaNueva = mapper.map(ventaDto, Venta.class);

        List<Prenda> prendas = prendaRepository.findAllById(
                ventaDto.getPrendas().stream().map(Prenda::getCodigo).toList()
        );
        ventaNueva.setPrendas(prendas);

        double totalVenta = prendas.stream()
                .mapToDouble(prenda -> prenda.getPrecioVenta() != null ? prenda.getPrecioVenta() : 0)
                .sum();
        ventaNueva.setTotal(totalVenta);

        for (Prenda prenda : prendas) {
            prenda.setCantidad(prenda.getCantidad() - 1);
            prendaRepository.save(prenda);
        }

        ventaRepository.save(ventaNueva);
        return ventaNueva.getNumero();
    }


    @Override
    public List<VentaDto> getVentas() {
        return ventaRepository.findAll().stream()
                .map(m->mapper.map(m,VentaDto.class))
                .toList();
    }

    @Override
    public VentaDto findVentaNumero(Long numero) {
        return mapper.map(ventaRepository.findByNumero(numero),VentaDto.class);
    }

    @Override
    public Long putVenta(Long numero, VentaDto ventaDto) {
        Venta venta = ventaRepository.findByNumero(numero);
        mapper.map(ventaDto,venta);
        ventaRepository.save(venta);
        return numero;
    }
    @Transactional
    @Override
    public Long deleteVenta(Long numero) {
        Venta venta = ventaRepository.findByNumero(numero)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada"));;
        ventaRepository.deleteByNumero(numero);
        return numero;
    }

    //    Traer todas las prendas de una determinada fecha
    @Override
    public List<VentaDto> findPrendasFecha(LocalDate fecha){
        return ventaRepository.findByFecha(fecha).stream()
                .map(m->mapper.map(m,VentaDto.class))
                .toList();
    }
    //    Traer la lista completa de prendas de una determinada venta.
    @Override
    public List<PrendaDto> findPrendasByVenta(Long numero){
        return ventaRepository.findByNumero(numero).getPrendas().stream()
                .map(m->mapper.map(m,PrendaDto.class))
                .toList();
    }
}
