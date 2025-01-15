package org.bootcampmeli.ejercitacionextrasql.service;

import org.bootcampmeli.ejercitacionextrasql.dto.VentaCreateRequestDTO;
import org.bootcampmeli.ejercitacionextrasql.dto.VentaCreateResponseDTO;

public interface IVentaService {
    VentaCreateResponseDTO addVenta(VentaCreateRequestDTO dto);
}
