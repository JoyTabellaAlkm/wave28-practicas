package com.example.showroom.service;

import com.example.showroom.dto.MessageDto;
import com.example.showroom.model.Prenda;

import java.util.List;

public interface IPrendaService {

    Prenda savePrenda(Prenda prenda);

    List<Prenda> findAllPrendas();

    Prenda findPrendaById(Long code);


    Prenda updatePrendaById(Prenda prenda, Long code);

    MessageDto deletePrenda(Long code);

    List<Prenda> findByTalle(String Talle);
}
