package com.testcase.service;

import com.testcase.DTO.TestCaseDto;
import com.testcase.DTO.responses.TestCaseDtoRes;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseService {
    public TestCaseDtoRes createTestCase(TestCaseDto testCase);
    public TestCaseDtoRes updateTestCase(Long id, TestCaseDto testCase);
    public void deleteTestCase(Long id);
    public List<TestCaseDtoRes> getAllTestCase(LocalDate last_update);
    public TestCaseDtoRes getTestCaseById(Long id);
}
