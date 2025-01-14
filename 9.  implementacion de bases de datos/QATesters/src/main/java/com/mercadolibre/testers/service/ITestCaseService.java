package com.mercadolibre.testers.service;

import com.mercadolibre.testers.dto.MessageDTO;
import com.mercadolibre.testers.dto.CreateTestCaseDTO;
import com.mercadolibre.testers.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    MessageDTO createTestCase(CreateTestCaseDTO test);

    List<TestCaseDTO> findAllTestCases();

    TestCaseDTO findTestCaseById(Long id);

    MessageDTO updateTestCase(Long id, CreateTestCaseDTO test);

    MessageDTO deleteTestCase(Long id);

    List<TestCaseDTO> findTestCasesAfterDate(LocalDate date);
}
