package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.PrendaDto;
import com.mercadolibre.showroom.dto.VentaDto;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    Long createVenta(VentaDto venta);
    List<VentaDto> getVentas();
    VentaDto getVentaByNumber(Long number);
    Long updateVenta(Long number, VentaDto venta);
    Long deleteVenta(Long number);
    List<VentaDto> getVentasByDate(LocalDate date);
    List<PrendaDto> getClothesFromVenta(Long number);
}
