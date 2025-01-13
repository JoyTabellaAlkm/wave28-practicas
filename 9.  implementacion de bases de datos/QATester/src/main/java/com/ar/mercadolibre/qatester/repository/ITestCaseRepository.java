package com.ar.mercadolibre.qatester.repository;

import com.ar.mercadolibre.qatester.dto.TestCaseDTO;
import com.ar.mercadolibre.qatester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findByLastUpdateAfter(LocalDate filerDate);
}
