package com.example.showroom.service;

import com.example.showroom.dto.MessageDto;
import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.VentaDto;
import com.example.showroom.dto.VentaWithAttributesDto;

import java.time.LocalDateTime;
import java.util.List;

public interface IVentaService {
    VentaWithAttributesDto createVenta(VentaDto ventaDto);
    List<VentaWithAttributesDto> getAllVentas ();
    VentaWithAttributesDto getVentaByNumber(Integer number);
    VentaWithAttributesDto updateVenta(VentaDto ventaDto, Integer numero);
    MessageDto deleteVenta(Integer numero);
    List<VentaDto> getVentasByDate(LocalDateTime date);
    List<PrendaDto> getPrendasByVentaNumber(Integer numero);
}
