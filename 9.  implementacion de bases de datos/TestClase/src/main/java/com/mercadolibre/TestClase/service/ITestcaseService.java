package com.mercadolibre.TestClase.service;

import com.mercadolibre.TestClase.dto.request.TestCaseRequestDTO;
import com.mercadolibre.TestClase.dto.response.TestCaseResponseDTO;
import com.mercadolibre.TestClase.entity.TestCase;

import java.util.List;

public interface ITestcaseService {
    public TestCaseResponseDTO saveTestcase(TestCaseRequestDTO testcase);
    public List<TestCase> findAll();
    public TestCaseResponseDTO findById(Long id);
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testcase);
    public String deleteTestCase(Long id);
    public List<TestCase> findByLastUpdate(String lastUpdate);
}