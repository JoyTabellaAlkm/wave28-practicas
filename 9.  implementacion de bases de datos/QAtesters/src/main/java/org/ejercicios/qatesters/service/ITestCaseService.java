package org.ejercicios.qatesters.service;

import org.ejercicios.qatesters.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseDto create(TestCaseDto testCase);
    List<TestCaseDto> getAll();
    TestCaseDto getById(Long id);
    TestCaseDto update(Long id, TestCaseDto testCase);
    void delete (Long id);
    List<TestCaseDto> getTestsByLastUpdate (LocalDate date);
}