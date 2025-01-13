package com.mercadolibre.qa_testers.service;

import com.mercadolibre.qa_testers.dto.MessageDTO;
import com.mercadolibre.qa_testers.dto.NewTestCaseDTO;
import com.mercadolibre.qa_testers.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCase {

    public TestCaseDTO save(NewTestCaseDTO testCaseDTO);
    public List<TestCaseDTO> getAll();
    public TestCaseDTO findById(Long id);
    public TestCaseDTO edit(Long id, TestCaseDTO testCaseDTO);
    public MessageDTO delete(Long id);
    public List<TestCaseDTO> filter(LocalDate date);
}
