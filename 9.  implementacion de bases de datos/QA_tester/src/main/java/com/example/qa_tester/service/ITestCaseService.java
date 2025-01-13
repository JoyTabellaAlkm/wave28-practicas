package com.example.qa_tester.service;

import com.example.qa_tester.dto.MessageDto;
import com.example.qa_tester.dto.TestCaseDto;
import com.example.qa_tester.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseDto create(TestCaseDto testCase);
    List<TestCaseDto> getAll();
    TestCaseDto getById(Long id);
    TestCaseDto update(Long id, TestCaseDto testCase);
    MessageDto delete (Long id);
    List<TestCaseDto> getTestsByLastUpdate (LocalDate date);
}
