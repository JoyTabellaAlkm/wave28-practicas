package com.example.testcase_api.service;

import com.example.testcase_api.dto.TestCaseDTO;
import com.example.testcase_api.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseService {


    public Long createTestCase(TestCaseDTO testCaseDTO);
    public List<TestCaseDTO> getTestCase();
    public TestCaseDTO findTestCaseById(Long id);
    public Long updateTestCase(Long id, TestCaseDTO testCaseDTO);
    public Long deleteTestCase(Long id);
    public List<TestCaseDTO> findTestCaseByLastUpdate(LocalDate lastUpdate);


}
