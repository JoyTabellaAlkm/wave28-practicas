package org.showroommysql.repository;

import org.showroommysql.entity.Ropa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RopaRepository extends JpaRepository<Ropa, Integer> {

    Ropa findByCodigo(int codigo);

    List<Ropa> findByTalle(String talle);

    List<Ropa> findByNombreIgnoreCase(String nombre);
}
