package com.example.showroom.service;

import com.example.showroom.dto.MessageDto;
import com.example.showroom.model.Prenda;
import com.example.showroom.repository.IPrendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements IPrendaService {

    @Autowired
    private IPrendaRepository prendaRepository;

    @Override
    public Prenda savePrenda(Prenda prenda){
        return  prendaRepository.save(prenda);
    }

    @Override
    public List<Prenda> findAllPrendas(){
        return prendaRepository.findAll();
    }

    @Override
    public Prenda findPrendaById(Long code){
        return prendaRepository.findById(code).get();
    }

    @Override
    public Prenda updatePrendaById(Prenda prenda, Long code){

        prenda.setCodigo(code);
        Prenda tempPrenda = findPrendaById(code);

        if (tempPrenda != null){
            return prendaRepository.save(prenda);
        }else {
            return null;
        }
    }

    @Override
    public MessageDto deletePrenda(Long code){
        prendaRepository.deleteById(code);
        return new MessageDto("Eliminado satisfactoriamente");
    }

    @Override
    public List<Prenda> findByTalle(String Talle){
        return prendaRepository.findByTalle(Talle);
    }

}
