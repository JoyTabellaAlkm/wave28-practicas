package com.testManagement.testCase.utils;

import com.testManagement.testCase.dto.request.NewTestCaseDTO;
import com.testManagement.testCase.dto.response.TestCaseDTO;
import com.testManagement.testCase.model.TestCase;

public class MapperTestCases {
    public static TestCase toEntity(NewTestCaseDTO testCaseDTO){
        TestCase testCase = new TestCase();
        testCase.setDescription(testCaseDTO.getDescription());
        testCase.setTested(testCaseDTO.isTested());
        testCase.setPassed(testCaseDTO.isPassed());
        testCase.setNumberOfTries(testCaseDTO.getNumberOfTries());
        testCase.setLastUpdate(testCaseDTO.getLastUpdate());

        return testCase;
    }

    public static TestCaseDTO toDTO(TestCase testCase){
        TestCaseDTO testCaseDTO = new TestCaseDTO();

        testCaseDTO.setIdCase(testCase.getIdCase());
        testCaseDTO.setDescription(testCase.getDescription());
        testCaseDTO.setTested(testCase.isTested());
        testCaseDTO.setPassed(testCase.isPassed());
        testCaseDTO.setNumberOfTries(testCase.getNumberOfTries());
        testCaseDTO.setLastUpdate(testCase.getLastUpdate());

        return testCaseDTO;
    }
}
