package com.example.AlumnoDTORP.repository;

import com.example.AlumnoDTORP.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {
}
