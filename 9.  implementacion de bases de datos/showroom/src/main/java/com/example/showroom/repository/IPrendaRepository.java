package com.example.showroom.repository;

import com.example.showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda, Long> {

    List<Prenda> findByTalle(String talle);
}
