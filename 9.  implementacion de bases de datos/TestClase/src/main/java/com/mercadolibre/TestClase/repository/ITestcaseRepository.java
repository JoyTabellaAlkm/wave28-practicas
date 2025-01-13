package com.mercadolibre.TestClase.repository;

import com.mercadolibre.TestClase.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestcaseRepository extends JpaRepository<TestCase, Long> {
}
