package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.request.TestCaseRequestDto;
import com.mercadolibre.qatesters.dto.response.TestCaseResponseDto;

import java.util.List;

public interface ITestCaseService {
    TestCaseResponseDto save(TestCaseRequestDto testCaseRequestDto);

    List<TestCaseResponseDto> findAll(String lastUpdate);

    TestCaseResponseDto findById(Long id);

    TestCaseResponseDto update(TestCaseRequestDto testCaseRequestDto, Long id);

    void delete(Long id);

}
