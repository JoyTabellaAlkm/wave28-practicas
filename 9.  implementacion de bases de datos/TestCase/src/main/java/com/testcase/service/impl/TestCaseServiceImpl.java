package com.testcase.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testcase.DTO.TestCaseDto;
import com.testcase.DTO.responses.TestCaseDtoRes;
import com.testcase.model.TestCase;
import com.testcase.repository.TestCaseRepository;
import com.testcase.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepo;

    @Autowired
    private ObjectMapper mapper;

    @Override
    @Transactional
    public TestCaseDtoRes createTestCase(TestCaseDto testCase) {
        TestCase newTestCase = testCaseRepo.save(mapper.convertValue(testCase, TestCase.class));
        return mapper.convertValue(newTestCase, TestCaseDtoRes.class);
    }

    @Override
    @Transactional
    public TestCaseDtoRes updateTestCase(Long id, TestCaseDto testCase) {
        TestCase updatedTestCase = testCaseRepo.save(new TestCase(
                id,
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate()
        ));
        return mapper.convertValue(updatedTestCase, TestCaseDtoRes.class);
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepo.deleteById(id);
    }

    @Override
    public List<TestCaseDtoRes> getAllTestCase(LocalDate last_update) {
        if (last_update == null){
            return testCaseRepo.findAll().stream()
                    .map(testCase -> mapper.convertValue(testCase, TestCaseDtoRes.class))
                    .toList();
        }else {
            List<TestCase> testCases = testCaseRepo.findByLastUpdate(last_update);
            return testCases.stream()
                    .map(testCase -> mapper.convertValue(testCase, TestCaseDtoRes.class))
                    .toList();
        }
    }

    @Override
    public TestCaseDtoRes getTestCaseById(Long id) {
        TestCase testCase = testCaseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("NO SE ENCONTRO TEST CON ESE ID"));
        System.out.println(testCase);
        return mapper.convertValue(testCase, TestCaseDtoRes.class);
    }
}
