package com.bootcamp.obrasLiterarias.service;

import com.bootcamp.obrasLiterarias.model.ObraLiteraria;

import java.util.List;

public interface IObraLiterariaService {
    public ObraLiteraria crear (ObraLiteraria obra);
    public List<ObraLiteraria> obtenerTodas();
    public ObraLiteraria obtenerPorId(Long id);
    public String borrar (Long id);
    public String actualizar (ObraLiteraria obra);
    public List<ObraLiteraria> obtenerPorAutor(String autor);
    public List<ObraLiteraria> obtenerPorNombreContenido(String nombre);
    public List<ObraLiteraria> obtenerTop5CantidadPaginasDesc();
    public List<ObraLiteraria> obtenerPorAnioPublicacioMenorA(Integer anio);
    public List<ObraLiteraria> obtenerPorEditorial(String editorial);
}
