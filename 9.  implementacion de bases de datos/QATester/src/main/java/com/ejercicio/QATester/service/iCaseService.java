package com.ejercicio.QATester.service;

import com.ejercicio.QATester.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface iCaseService {

    public List<TestCase> getAllTestCase();

    public TestCase getById(Long id);

    public TestCase saveTestCase(TestCase tc);

    public TestCase updateTestCase(TestCase tc, Long id);

    public String deleteTestCase(Long id);

    public List<TestCase> findByDate(LocalDate fecha);
}
