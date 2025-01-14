package com.mercadolibre.testers.repository;

import com.mercadolibre.testers.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
