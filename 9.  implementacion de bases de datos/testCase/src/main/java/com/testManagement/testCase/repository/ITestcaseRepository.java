package com.testManagement.testCase.repository;

import com.testManagement.testCase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestcaseRepository extends JpaRepository<TestCase,Long> {
    @Query("SELECT t FROM TestCase t WHERE t.lastUpdate > :date")
    List<TestCase> findTestCasesUpdatedAfter(@Param("date") LocalDate date);
}
