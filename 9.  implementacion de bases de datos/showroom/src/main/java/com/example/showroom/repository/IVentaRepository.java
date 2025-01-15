package com.example.showroom.repository;

import com.example.showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVentaRepository extends JpaRepository<Prenda, Long> {

}
