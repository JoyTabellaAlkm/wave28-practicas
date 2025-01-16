package com.melibootcamp.showroom.service;

import com.melibootcamp.showroom.dto.VentaDto;
import com.melibootcamp.showroom.entity.Venta;

import java.util.List;

public interface VentaService {

    public List<VentaDto> getVentas();
    public boolean saveVenta (VentaDto venta);
    public boolean deleteVenta (long id);
    public VentaDto getVentaById(long id);

    public boolean updateVenta(long id, VentaDto venta);
}
