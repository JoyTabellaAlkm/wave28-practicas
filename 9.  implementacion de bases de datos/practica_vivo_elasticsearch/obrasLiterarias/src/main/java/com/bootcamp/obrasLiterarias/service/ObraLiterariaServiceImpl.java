package com.bootcamp.obrasLiterarias.service;

import com.bootcamp.obrasLiterarias.exception.NotFoundException;
import com.bootcamp.obrasLiterarias.model.ObraLiteraria;
import com.bootcamp.obrasLiterarias.repository.ObraLiterariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService{

    ObraLiterariaRepository repository;

    public ObraLiterariaServiceImpl(ObraLiterariaRepository repository){
        this.repository = repository;
    }

    @Override
    public ObraLiteraria crear(ObraLiteraria obra) {
        return repository.save(obra);
    }

    @Override
    public List<ObraLiteraria> obtenerTodas() {
        return (List<ObraLiteraria>) repository.findAll();
    }

    @Override
    public ObraLiteraria obtenerPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No se encontró la obra"));
    }

    @Override
    public String borrar(Long id) {
        repository.deleteById(id);
        return "Obra eliminado correctamente";
    }

    @Override
    public String actualizar(ObraLiteraria obra) {
        repository.save(obra);
        return "Obra modificada correctamente";
    }

    public List<ObraLiteraria> obtenerPorAutor(String autor) {
        return repository.findAllByAutor(autor);
    }

    public List<ObraLiteraria> obtenerPorNombreContenido(String nombre) {
        return repository.findAllByNombre(nombre);
    }

    public List<ObraLiteraria> obtenerTop5CantidadPaginasDesc() {
        return repository.findTop5ByOrderByCantidadDePaginasDesc();
    }

    public List<ObraLiteraria> obtenerPorAnioPublicacioMenorA(Integer anio) {
        return repository.getObraLiterariaByAnioDePublicacionLessThan(anio);
    }

    public List<ObraLiteraria> obtenerPorEditorial(String editorial) {
        return repository.findallByEditorial(editorial);
    }
}
