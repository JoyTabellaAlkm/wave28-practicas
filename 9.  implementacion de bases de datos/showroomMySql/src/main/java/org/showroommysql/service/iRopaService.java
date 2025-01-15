package org.showroommysql.service;

import org.showroommysql.entity.Ropa;

import java.util.List;

public interface iRopaService {
    public Ropa create(Ropa r);
    public List<Ropa> getAll();
    public Ropa getEspecificClothe(int codigo);
    public Ropa updateClothe(int codigo, Ropa r);
    public void deleteClothe(int codigo);
    public List<Ropa> getTalle(String talle);
    public List<Ropa> getNombre(String nombre);

}
