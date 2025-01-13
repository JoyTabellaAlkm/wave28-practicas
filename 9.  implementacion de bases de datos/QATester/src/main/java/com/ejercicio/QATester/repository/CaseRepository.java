package com.ejercicio.QATester.repository;

import com.ejercicio.QATester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<TestCase, Long> {
    public TestCase findByIdCase(Long id);

    public List<TestCase> findAllByLastUpdateAfter(LocalDate fecha);
}
