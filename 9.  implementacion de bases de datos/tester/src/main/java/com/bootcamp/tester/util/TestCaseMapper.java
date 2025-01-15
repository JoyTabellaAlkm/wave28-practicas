package com.bootcamp.tester.util;

import com.bootcamp.tester.dto.TestCaseCreationDto;
import com.bootcamp.tester.dto.TestCaseDto;
import com.bootcamp.tester.entity.TestCase;

import java.time.LocalDate;

public class TestCaseMapper {
    public static TestCase toTestCase(TestCaseCreationDto dto) {
        TestCase testCase = new TestCase();
        testCase.setTested(dto.getTested());
        testCase.setDescription(dto.getDescription());
        testCase.setPassed(dto.getPassed());
        testCase.setNumberOfTries(dto.getNumberOfTries());
        return testCase;
    }

    public static TestCaseDto toTestCaseDto(TestCase testCase) {
        return new TestCaseDto(
            testCase.getIdCase(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate()
        );
    }
}
