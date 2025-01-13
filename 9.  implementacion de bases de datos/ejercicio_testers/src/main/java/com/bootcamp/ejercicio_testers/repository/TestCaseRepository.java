package com.bootcamp.ejercicio_testers.repository;
import com.bootcamp.ejercicio_testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findByLastUpdateAfter(LocalDate date);
}
