package org.bootcampmeli.ejercicioconcesionaria.repository;


import lombok.NoArgsConstructor;
import org.bootcampmeli.ejercicioconcesionaria.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehiculoRepository {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    public List<Vehiculo> findAll() {
        return vehiculos;
    }

    public Long save(Vehiculo vehiculo) {

        vehiculos.add(vehiculo);

        return vehiculo.getId();
    }

}
