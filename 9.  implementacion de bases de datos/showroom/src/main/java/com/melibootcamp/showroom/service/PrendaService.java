package com.melibootcamp.showroom.service;



import com.melibootcamp.showroom.entity.Prenda;

import java.util.List;

public interface PrendaService {

    public List<Prenda> getPrendas();
    public boolean savePrenda (Prenda prenda);
    public boolean deletePrenda (long id);
    public Prenda getPrendaById(long id);

    public boolean updatePrenda(long id, Prenda prenda);

    public List<Prenda> getPrendaBySize(String talle);

    public List<Prenda> getPrendaByPatternOnTitle(String pattern);

}
