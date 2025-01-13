package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void post(TestCaseDto testCaseDto);
    List<TestCaseDto> getAll();
    TestCaseDto getById(Long id);
    void put(Long id, TestCaseDto testCaseDto);
    void delete(Long id);
    List<TestCaseDto> filter(LocalDate lastUpdate);
}
