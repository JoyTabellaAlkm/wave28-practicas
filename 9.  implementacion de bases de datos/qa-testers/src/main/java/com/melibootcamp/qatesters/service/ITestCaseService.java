package com.melibootcamp.qatesters.service;


import com.melibootcamp.qatesters.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    public List<TestCase> getTestCases();
    public boolean saveTestCase (TestCase testCase);
    public boolean deleteTestCase (long id);
    public TestCase getTestCaseById(long id);

    public boolean updateTestCase(long id, TestCase testcase);

    public List<TestCase> getFilteredTestCases(LocalDate filter);
}
