package org.showroommysql.service;

import org.showroommysql.entity.Ropa;
import org.showroommysql.entity.Venta;

import java.time.LocalDate;
import java.util.List;

public interface iVentaService {
    public Venta create(Venta r);
    public List<Venta> getAll();
    public Venta getEspecificSale(int numero);
    public Venta updateSale(int numero, Venta r);
    public void deleteSale(int numero);
    public List<Venta> getAllDate(LocalDate fecha);
    public List<Ropa> getAllClotheBySale(int numero);
}
