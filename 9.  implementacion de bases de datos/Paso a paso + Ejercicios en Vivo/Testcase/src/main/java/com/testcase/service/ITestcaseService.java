package com.testcase.service;

import com.testcase.dto.request.TestCaseRequestDTO;
import com.testcase.dto.response.TestCaseResponseDTO;
import com.testcase.model.TestCase;

import java.util.List;

public interface ITestcaseService {
    public TestCaseResponseDTO saveTestcase(TestCaseRequestDTO testcase);
    public List<TestCase> findAll();
    public TestCaseResponseDTO findById(Long id);
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testcase);
    public String deleteTestCase(Long id);
    public List<TestCase> findByLastUpdate(String lastUpdate);
}