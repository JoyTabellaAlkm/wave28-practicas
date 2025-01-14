package com.example.AlumnoDTORP.repository;

import com.example.AlumnoDTORP.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {


}
