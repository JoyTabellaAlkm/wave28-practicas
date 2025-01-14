package com.example.testcase_api.repository;

import com.example.testcase_api.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase,Long> {
    List<TestCase> findByLastUpdate(LocalDate lastUpdate);

}
