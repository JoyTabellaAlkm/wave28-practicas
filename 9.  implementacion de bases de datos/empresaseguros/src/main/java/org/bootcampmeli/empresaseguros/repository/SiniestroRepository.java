package org.bootcampmeli.empresaseguros.repository;

import org.bootcampmeli.empresaseguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {
}
