package com.demo.demo.service;

import com.demo.demo.dto.VentaDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    VentaDTO save(VentaDTO venta);
    List<VentaDTO> findAll();
    List<VentaDTO> findAllByDate(String date);
}
