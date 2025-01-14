package com.bootcamp.SegurosAutos.repository.projection;

import java.util.Optional;

public interface VehiculoSiniestroProjection {
        String getPatente();
        String getMarca();
        String getModelo();
        Optional<Double> getPerdidaTotal();  // Puede ser null si no se calcula
}
