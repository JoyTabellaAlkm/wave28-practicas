package com.example.showroom.service;

import com.example.showroom.model.Prenda;

import java.util.List;

public interface IVentaService {
    Prenda saveVenta(Prenda prenda);

    List<Prenda> findAllVentas();

    Prenda findVentaById(Long code);
}
