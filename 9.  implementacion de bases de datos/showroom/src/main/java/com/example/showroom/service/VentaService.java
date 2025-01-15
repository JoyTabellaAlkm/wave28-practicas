package com.example.showroom.service;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.VentaDto;

import java.time.LocalDate;
import java.util.List;

public interface VentaService {

    Long postVenta(VentaDto ventaDto);
    List<VentaDto> getVentas();
    VentaDto findVentaNumero(Long numero);
    Long putVenta(Long numero, VentaDto ventaDto);
    Long deleteVenta(Long numero);

    //    Traer todas las prendas de una determinada fecha
    List<VentaDto> findPrendasFecha(LocalDate fecha);

    //    Traer la lista completa de prendas de una determinada venta.
    List<PrendaDto> findPrendasByVenta(Long numero);
}
