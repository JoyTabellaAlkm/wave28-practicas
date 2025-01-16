package com.melibootcamp.showroom.service;



import com.melibootcamp.showroom.dto.PrendaDto;
import com.melibootcamp.showroom.entity.Prenda;

import java.util.List;

public interface PrendaService {

    public List<PrendaDto> getPrendas();
    public boolean savePrenda (PrendaDto prenda);
    public boolean deletePrenda (long id);
    public PrendaDto getPrendaById(long id);

    public boolean updatePrenda(long id, PrendaDto prenda);

    public List<PrendaDto> getPrendaBySize(String talle);

    public List<PrendaDto> getPrendaByPatternOnTitle(String pattern);

}
