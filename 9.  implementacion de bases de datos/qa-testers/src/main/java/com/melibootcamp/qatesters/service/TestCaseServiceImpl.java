package com.melibootcamp.qatesters.service;


import com.melibootcamp.qatesters.entity.TestCase;
import com.melibootcamp.qatesters.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final TestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository){
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public List<TestCase> getTestCases() {
        List<TestCase> toReturn = testCaseRepository.findAll();
        return toReturn;
    }

    @Override
    public boolean saveTestCase(TestCase TestCase) {
        try{
            testCaseRepository.save(TestCase);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteTestCase(long id) {
        try{
            testCaseRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public TestCase getTestCaseById(long id) {
        TestCase toReturn = testCaseRepository.findById(id).orElse(null);
        return toReturn;
    }

    @Override
    public boolean updateTestCase(long id, TestCase testcase) {

        if (!testCaseRepository.existsById(id)){
            return false;
        }

        testcase.setId_case(id);

        testCaseRepository.save(testcase);
        return true;
    }

    @Override
    public List<TestCase> getFilteredTestCases(LocalDate filter) {
        List<TestCase> testCases = testCaseRepository.findAll().stream()
                .filter( x -> x.getLast_update().isAfter(filter))
                .toList();
        return testCases;
    }
}
