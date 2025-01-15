package org.showroommysql.service.impl;

import org.showroommysql.entity.Ropa;
import org.showroommysql.repository.RopaRepository;
import org.showroommysql.service.iRopaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RopaService implements iRopaService {

    @Autowired
    private RopaRepository repo;

    @Override
    public Ropa create(Ropa r) {
        return repo.save(r);
    }

    @Override
    public List<Ropa> getAll() {
        return repo.findAll();
    }

    @Override
    public Ropa getEspecificClothe(int codigo) {
        return repo.findByCodigo(codigo);
    }

    @Override
    public Ropa updateClothe(int codigo, Ropa r) {
        Ropa original = repo.findByCodigo(codigo);
        if (original == null){
            return null;
        }
        original.setCantidad(r.getCantidad());
        original.setColor(r.getColor());
        original.setMarca(r.getMarca());
        original.setNombre(r.getNombre());
        original.setPrecio(r.getPrecio());
        original.setTipo(r.getTipo());
        original.setTalle(r.getTalle());
        repo.save(original);
        return original;
    }

    @Override
    public void deleteClothe(int codigo) {
        Ropa eliminar = repo.findByCodigo(codigo);
        repo.delete(eliminar);
    }

    @Override
    public List<Ropa> getTalle(String talle) {
        return repo.findByTalle(talle);
    }

    @Override
    public List<Ropa> getNombre(String nombre) {
        return repo.findByNombreIgnoreCase(nombre);
    }
}
