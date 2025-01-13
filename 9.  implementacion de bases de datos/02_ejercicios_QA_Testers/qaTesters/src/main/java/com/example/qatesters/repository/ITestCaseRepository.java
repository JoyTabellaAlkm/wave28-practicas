package com.example.qatesters.repository;

import com.example.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findByLastUpdateAfter(java.time.LocalDate date);
}
