package com.mercadolibre.testers.service;

import com.mercadolibre.testers.dto.MessageDTO;
import com.mercadolibre.testers.dto.CreateTestCaseDTO;
import com.mercadolibre.testers.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITestCaseService {
    MessageDTO createCaseTest(CreateTestCaseDTO test);
    List<TestCaseDTO> findAllCase();
    TestCaseDTO findCaseById(Long id);
    MessageDTO updateCase(Long id, CreateTestCaseDTO test);
    MessageDTO deleteCase(Long id);
    List<TestCaseDTO> findByDate(LocalDate date);

}
