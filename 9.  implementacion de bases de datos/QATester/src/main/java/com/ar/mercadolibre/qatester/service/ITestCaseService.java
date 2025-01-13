package com.ar.mercadolibre.qatester.service;

import com.ar.mercadolibre.qatester.dto.MessageDTO;
import com.ar.mercadolibre.qatester.dto.TestCaseDTO;

import java.util.List;

public interface ITestCaseService {
    TestCaseDTO createTestCase(TestCaseDTO testCaseDTO);
    List<TestCaseDTO> findAll();
    TestCaseDTO findById(Long id);
    TestCaseDTO update(Long id, TestCaseDTO testCaseDTO);
    MessageDTO delete(Long id);
    List<TestCaseDTO> findAfterLastUpdate(String lastUpdate);
}
