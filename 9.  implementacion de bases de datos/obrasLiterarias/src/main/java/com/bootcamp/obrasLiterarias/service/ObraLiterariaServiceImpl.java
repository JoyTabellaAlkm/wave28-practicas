package com.bootcamp.obrasLiterarias.service;

import com.bootcamp.obrasLiterarias.model.ObraLiteraria;
import com.bootcamp.obrasLiterarias.repository.ObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService{

    ObraLiterariaRepository repository;

    public ObraLiterariaServiceImpl(ObraLiterariaRepository repository){
        this.repository = repository;
    }

    @Override
    public ObraLiteraria save(ObraLiteraria obra) {
        return repository.save(obra);
    }

    @Override
    public List<ObraLiteraria> findAll() {
        return (List<ObraLiteraria>) repository.findAll();
    }

    @Override
    public Optional<ObraLiteraria> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public String deleteObra(Long id) {
        repository.deleteById(id);
        return "Obra eliminado correctamente";
    }

    @Override
    public String editObra(ObraLiteraria obra) {
        repository.save(obra);
        return "Obra modificada correctamente";
    }
}
