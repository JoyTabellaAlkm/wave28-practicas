package org.showroom.service;

import org.showroom.entity.Ropa;

import java.util.List;

public interface iShowroomService {

    public void postClothe(Ropa r);
    public List<Ropa> getAll();
    public Ropa getEspecificClothe(int r);
    public Ropa updateClothe(int codigo, Ropa r);
    public void deleteClothe(int codigo);
    public List<Ropa> findBySize(String talle);
    public List<Ropa> findByName(String name);
}
