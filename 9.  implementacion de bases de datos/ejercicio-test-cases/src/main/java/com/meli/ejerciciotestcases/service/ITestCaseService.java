package com.meli.ejerciciotestcases.service;

import com.meli.ejerciciotestcases.dto.TestCaseDto;
import com.meli.ejerciciotestcases.model.TestCase;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITestCaseService {
    public List<TestCaseDto> getTestCases();
    public void saveTestCase(TestCaseDto testCase);
    public void deleteStudend(long id);
    public TestCaseDto findTestCase(Long id);
}
