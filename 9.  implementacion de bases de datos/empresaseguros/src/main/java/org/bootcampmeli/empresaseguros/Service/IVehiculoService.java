package org.bootcampmeli.empresaseguros.Service;

import org.bootcampmeli.empresaseguros.dto.SiniestroDto;
import org.bootcampmeli.empresaseguros.model.Siniestro;
import org.bootcampmeli.empresaseguros.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    Vehiculo createVehiculo(Vehiculo vehiculo);

    Siniestro createSiniestro(Siniestro siniestro);

    List<Vehiculo> getVehiculos();

    List<SiniestroDto> getSiniestros();

    List<String> getPatentes();
}
