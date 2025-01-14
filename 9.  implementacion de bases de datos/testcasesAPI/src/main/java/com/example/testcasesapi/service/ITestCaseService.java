package com.example.testcasesapi.service;

import com.example.testcasesapi.dto.request.RequestTestCaseDto;
import com.example.testcasesapi.dto.response.ResponseDto;
import com.example.testcasesapi.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    ResponseDto create(RequestTestCaseDto requestTestCaseDto);

    List<TestCase> getAll();

    TestCase show(Long id);

    TestCase update(Long id, RequestTestCaseDto requestTestCaseDto);

    ResponseDto delete(Long id);

    List<TestCase> getAllByDate(LocalDate lastUpdate);
}
