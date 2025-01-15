package org.bootcampmeli.ejercitacionextrasql.repository;

import org.bootcampmeli.ejercitacionextrasql.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
