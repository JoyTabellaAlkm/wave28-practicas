package com.demo.QATesters.repository;

import com.demo.QATesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase,Long> {
    Collection<Object> findTestCaseByLastUpdateAfter(LocalDate lastUpdate);
}
