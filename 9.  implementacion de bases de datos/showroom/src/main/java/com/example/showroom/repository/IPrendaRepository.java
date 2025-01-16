package com.example.showroom.repository;

import com.example.showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {
    List<Prenda> findByTallaIgnoreCase(String talla);
    List<Prenda> findByNombreLikeIgnoreCase(String nombre);
}
