package com.mercadolibre.showroom.service;


import com.mercadolibre.showroom.dto.PrendaDto;
import com.mercadolibre.showroom.dto.VentaDto;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    Integer generarNuevaVenta(VentaDto ventaDto);
    List<VentaDto> obtenerVentas();
    VentaDto obtenerVenta(Integer numero);
    VentaDto actualizarVenta(Integer numero, VentaDto ventaDto);
    void eliminarVenta(Integer numero);
    List<VentaDto> obtenerVentasXFecha(LocalDate fecha);
    List<PrendaDto> obtenerPrendasXVenta(Integer numero);
}
