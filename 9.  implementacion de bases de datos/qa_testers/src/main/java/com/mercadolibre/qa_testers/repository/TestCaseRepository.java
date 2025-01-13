package com.mercadolibre.qa_testers.repository;

import com.mercadolibre.qa_testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    @Query("SELECT t FROM TestCase t WHERE t.lastUpdate > :date")
    public List<TestCase> filterByDate(@Param("date") LocalDate date);

    List<TestCase> findByLastUpdateAfter(LocalDate date);

}
