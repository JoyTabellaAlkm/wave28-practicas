package com.example.showroom.service;

import com.example.showroom.model.Prenda;
import com.example.showroom.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VentaServiceImpl implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public Prenda saveVenta(Prenda prenda){
        return  ventaRepository.save(prenda);
    }

    @Override
    public List<Prenda> findAllVentas(){
        return ventaRepository.findAll();
    }

    @Override
    public Prenda findVentaById(Long code){
        return ventaRepository.findById(code).get();
    }
}
