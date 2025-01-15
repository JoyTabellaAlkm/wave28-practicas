package org.showroom.service;

import org.showroom.entity.Ropa;
import org.showroom.repository.ShowroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowroomService implements iShowroomService{

    @Autowired
    private ShowroomRepository repo;

    @Override
    public void postClothe(Ropa r) {
        repo.save(r);
    }

    @Override
    public List<Ropa> getAll() {
        return repo.findAllRopa();
    }

    @Override
    public Ropa getEspecificClothe(int r) {
        return repo.findByCodigoEquals(r);
    }

    @Override
    public Ropa updateClothe(int codigo, Ropa r) {
        Ropa original = repo.findByCodigoEquals(codigo);
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
        Ropa eliminar = repo.findByCodigoEquals(codigo);
        repo.delete(eliminar);
    }

    @Override
    public List<Ropa> findBySize(String talle) {
        return repo.findByTalle(talle);
    }

    @Override
    public List<Ropa> findByName(String name) {
        return repo.findByNombreIgnoreCase(name);
    }
}
