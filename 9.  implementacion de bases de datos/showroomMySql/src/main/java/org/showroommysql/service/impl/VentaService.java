package org.showroommysql.service.impl;

import org.showroommysql.entity.Ropa;
import org.showroommysql.entity.Venta;
import org.showroommysql.repository.VentaRepository;
import org.showroommysql.service.iVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements iVentaService {

    @Autowired
    private VentaRepository repo;

    @Override
    public Venta create(Venta r) {
        return repo.save(r);
    }

    @Override
    public List<Venta> getAll() {
        return repo.findAll();
    }

    @Override
    public Venta getEspecificSale(int numero) {
        return repo.findByNumero(numero);
    }

    @Override
    public Venta updateSale(int numero, Venta r) {
        Venta original = repo.findByNumero(numero);
        if(original == null)
            return null;
        original.setFecha(r.getFecha());
        original.setRopa(r.getRopa());
        original.setTotal(r.getTotal());
        original.setMedioDePago(r.getMedioDePago());
        return original;
    }

    @Override
    public void deleteSale(int numero) {
        Venta eliminar = repo.findByNumero(numero);
        repo.delete(eliminar);
    }

    @Override
    public List<Venta> getAllDate(LocalDate fecha) {
        return repo.findByFecha(fecha);
    }

    @Override
    public List<Ropa> getAllClotheBySale(int numero) {
        return repo.prendasVenta(numero);
    }
}
