package com.testManagement.testCase.service;

import com.testManagement.testCase.dto.request.NewTestCaseDTO;
import com.testManagement.testCase.dto.response.MessageDTO;
import com.testManagement.testCase.dto.response.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCasesService {
    TestCaseDTO createTestCase(NewTestCaseDTO testCaseDTO);
    List<TestCaseDTO> getAllTestCases();
    TestCaseDTO getById(Long id);
    TestCaseDTO update(NewTestCaseDTO testCaseDTO, Long id);
    MessageDTO deleteById(Long id);
    List<TestCaseDTO> getTestCasesWithFilter(LocalDate date);
}
